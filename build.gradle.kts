plugins {
    kotlin("jvm") version "2.4.0"
    `maven-publish`
}

group = "gg.sona"
version = "2.2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

@OptIn(org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation::class)
kotlin {
    abiValidation {}
    jvmToolchain(8)
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
    }
}

java {
    withSourcesJar()
}

// region eos-jni Rust shim build wiring
//
// This shim (native/eos-jni) is our own Apache-2.0 code with no third-party IP - unlike the EOS SDK
// binary (which this build never touches and never bundles, see internal/Native.kt), it is safe and
// expected to ship inside this library's own jar. Building it requires a Rust toolchain; contributors
// who only touch Kotlin facade code aren't required to have one installed - buildRustShim becomes a
// no-op (with a warning) when `cargo` isn't found, matching NativeLibraryTest's existing precedent of
// skipping native-dependent tests when the native pieces aren't available locally.

fun isCargoAvailable(): Boolean = runCatching {
    ProcessBuilder("cargo", "--version").redirectErrorStream(true).start().waitFor() == 0
}.getOrDefault(false)

fun currentShimPlatformDir(): String {
    val os = System.getProperty("os.name").lowercase()
    val arch = System.getProperty("os.arch").lowercase()
    val osKey = when {
        os.contains("win") -> "windows"
        os.contains("mac") || os.contains("darwin") -> "macos"
        else -> "linux"
    }
    val archKey = if (arch.contains("aarch64") || arch.contains("arm64")) "aarch64" else "x86_64"
    return "$osKey-$archKey"
}

fun currentShimFileName(): String {
    val os = System.getProperty("os.name").lowercase()
    return when {
        os.contains("win") -> "eos_jni.dll"
        os.contains("mac") || os.contains("darwin") -> "libeos_jni.dylib"
        else -> "libeos_jni.so"
    }
}

val eosJniDir = file("native/eos-jni")
val generatedResourcesDir = layout.buildDirectory.dir("generated-resources")

val buildRustShim by tasks.registering(Exec::class) {
    description = "Builds the eos-jni Rust/JNI shim for the host platform (cargo build --release)."
    workingDir = eosJniDir
    commandLine("cargo", "build", "--release")
    isIgnoreExitValue = true
    inputs.dir(eosJniDir.resolve("src"))
    inputs.file(eosJniDir.resolve("Cargo.toml"))
    outputs.dir(eosJniDir.resolve("target/release"))
    onlyIf {
        if (!isCargoAvailable()) {
            logger.warn(
                "eos-jni: `cargo` was not found on PATH - skipping the Rust shim build. Native-dependent " +
                        "tests will be skipped too. Install the Rust toolchain to build/test the shim."
            )
            false
        } else {
            true
        }
    }
}

val copyRustShimResources by tasks.registering(Copy::class) {
    description = "Stages the built eos-jni shim under natives/jni/<platform>/ for the test/runtime classpath."
    dependsOn(buildRustShim)
    val fileName = currentShimFileName()
    from(eosJniDir.resolve("target/release/$fileName"))
    into(generatedResourcesDir.map { it.dir("natives/jni/${currentShimPlatformDir()}") })
    onlyIf { eosJniDir.resolve("target/release/$fileName").exists() }
}

// Deliberately NOT added via `sourceSets.main.resources.srcDir(...)`: that convention also feeds
// `sourcesJar` (which packages `allSource`, resources included) - a compiled binary has no business
// in a *sources* jar. Instead, only the actual resource-processing/packaging task gets the extra
// input, via `from(...)` directly on the Copy-typed `processResources` task.
tasks.named<Copy>("processResources") {
    dependsOn(copyRustShimResources)
    from(generatedResourcesDir)
}
tasks.named("test") { dependsOn(copyRustShimResources) }

// endregion

// Treats a blank/empty value (e.g. an unset GitHub Actions secret, which interpolates to "" rather
// than being genuinely absent) the same as an absent one, so optional settings like cloverUrl still
// fall through to their default instead of resolving to an empty string. (Provider.map disallows
// returning null from the transform, so this resolves eagerly to a plain nullable String instead.)
fun setting(property: String, environment: String): String? =
    (providers.gradleProperty(property).orNull ?: providers.environmentVariable(environment).orNull)
        ?.takeIf { it.isNotBlank() }

val cloverUsername = setting("cloverUsername", "CLOVER_MAVEN_USERNAME")
val cloverPassword = setting("cloverPassword", "CLOVER_MAVEN_PASSWORD")
val cloverUrl = setting("cloverUrl", "CLOVER_MAVEN_URL")

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "eos"

            pom {
                name = "EOS for Kotlin"
                description = "Kotlin bindings for the EOS SDK, running on Java 8+ via a small " +
                        "bundled JNI bridge."
                url = "https://maven.cloverclient.com"
            }
        }
    }

    repositories {
        maven {
            name = "Clover"

            url = uri(
                cloverUrl ?: if (version.toString().endsWith("SNAPSHOT")) {
                    "https://maven.cloverclient.com/snapshots"
                } else {
                    "https://maven.cloverclient.com/releases"
                },
            )

            credentials {
                username = cloverUsername
                password = cloverPassword
            }
        }
    }
}
