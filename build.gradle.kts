/*
 * Copyright 2026 Sona Interactive, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform") version "2.4.20"
    kotlin("jvm") version "2.4.20" apply false
    `maven-publish`
}

group = "gg.sona"
version = "3.0.0"

repositories {
    mavenCentral()
}

@OptIn(org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation::class)
kotlin {
    abiValidation {}

    jvm {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_1_8)
    }
    jvmToolchain(8)

    mingwX64()
    linuxX64()
    linuxArm64()
    macosArm64()
    macosX64()

    applyDefaultHierarchyTemplate {
        common {
            group("native") {
                group("posix") {
                    withLinux()
                    withApple()
                }
            }
        }
    }

    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
        optIn.add("kotlinx.cinterop.ExperimentalForeignApi")
        optIn.add("kotlin.concurrent.atomics.ExperimentalAtomicApi")
    }

    sourceSets {
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

val generator by configurations.creating {
    isCanBeConsumed = false
    attributes.attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
}

dependencies {
    generator(project(":generator"))
}

val generateBindings by tasks.registering(JavaExec::class) {
    description = "Generates the native invokers from the EOS SDK headers. Set -PeosSdk to the SDK folder."
    classpath = generator
    mainClass.set("gg.sona.eos.generator.MainKt")
    javaLauncher.set(javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(25)) })
    val sdk = providers.gradleProperty("eosSdk").orElse(providers.environmentVariable("EOS_SDK"))
    doFirst { require(sdk.isPresent) { "Set -PeosSdk or EOS_SDK to the EOS SDK folder" } }
    argumentProviders += CommandLineArgumentProvider {
        listOf(File(sdk.get(), "SDK/Include").path, layout.projectDirectory.dir("src/nativeMain/kotlin").asFile.path, layout.projectDirectory.dir("src/commonMain/kotlin").asFile.path)
    }
}

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
        isCargoAvailable().also { if (!it) logger.warn("eos-jni: cargo was not found, so the JNI bridge is not built.") }
    }
}

val copyRustShimResources by tasks.registering(Copy::class) {
    description = "Stages the built eos-jni shim under natives/jni/<platform>/."
    dependsOn(buildRustShim)
    val fileName = currentShimFileName()
    from(eosJniDir.resolve("target/release/$fileName"))
    into(generatedResourcesDir.map { it.dir("natives/jni/${currentShimPlatformDir()}") })
    onlyIf { eosJniDir.resolve("target/release/$fileName").exists() }
}

fun setting(property: String, environment: String): String? =
    (providers.gradleProperty(property).orNull ?: providers.environmentVariable(environment).orNull)
        ?.takeIf { it.isNotBlank() }

val cloverUsername = setting("cloverUsername", "CLOVER_MAVEN_USERNAME")
val cloverPassword = setting("cloverPassword", "CLOVER_MAVEN_PASSWORD")
val cloverUrl = setting("cloverUrl", "CLOVER_MAVEN_URL")

tasks.named<Copy>("jvmProcessResources") {
    dependsOn(copyRustShimResources)
    from(generatedResourcesDir)
}
tasks.named("jvmTest") { dependsOn(copyRustShimResources) }
tasks.withType<org.jetbrains.kotlin.gradle.targets.native.tasks.KotlinNativeTest>().configureEach {
    providers.gradleProperty("eosLibrary").orNull?.let { environment("EOS_SDK_LIBRARY", it) }
}

publishing {
    publications.withType<MavenPublication>().configureEach {
        pom {
            name = "EpicOnlineServices"
            description = "Kotlin Multiplatform bindings for the Epic Online Services SDK. The JVM target runs on Java 8+."
            url = "https://maven.cloverclient.com"
        }
    }
    repositories {
        maven {
            name = "Clover"
            url = uri(
                cloverUrl ?: if (version.toString().endsWith("SNAPSHOT")) "https://maven.cloverclient.com/snapshots"
                else "https://maven.cloverclient.com/releases",
            )
            credentials {
                username = cloverUsername
                password = cloverPassword
            }
        }
    }
}
