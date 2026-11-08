plugins {
    kotlin("jvm")
}

kotlin {
    jvmToolchain(25)
    compilerOptions.optIn.add("com.squareup.kotlinpoet.ExperimentalKotlinPoetApi")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup:kotlinpoet:2.2.0")
}
