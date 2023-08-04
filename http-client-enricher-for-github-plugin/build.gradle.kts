plugins {
    `java-library`
    alias(libs.plugins.gradle.intellij.plugin)
    alias(libs.plugins.kotlin.plugin)
}

repositories {
    mavenCentral()
}

dependencies {
    // SLF4J is already present in the Intellij Platform at runtime, so we only need it at compile time
    compileOnly(libs.slf4j.api)
}

kotlin {

    /**
     * Target Java 17
     * Note: It's important to use the same version of Java that powers the Intellij Platform at runtime. We don't want
     * to develop a plugin using Java 20 only to find out that Intellij can't run it because Intellij runs on Java 17.
     */
    jvmToolchain(17)
}

kotlin {
    sourceSets {
        main {
            languageSettings {
                // It's important to target the same version of Kotlin that powers the Intellij Platform at runtime.
                // We don't want to mistakenly code to newer Kotlin language features only to have the plugin fail at
                // runtime.
                //
                // See https://plugins.jetbrains.com/docs/intellij/using-kotlin.html#kotlin-standard-library
                languageVersion = "1.8"
            }
        }
    }
}

intellij {
    version.set("2023.2")
    type.set("IU")
    plugins.set(listOf("com.jetbrains.restClient"))
}
