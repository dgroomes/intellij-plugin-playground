plugins {
    `java-library`
    alias(libs.plugins.gradle.intellij.plugin)
}

repositories {
    mavenCentral()
}

dependencies {
    // SLF4J is already present in Intellij at runtime, so we only need it at compile time
    compileOnly(libs.slf4j.api)
}

java {

    /**
     * Use Java 17
     *
     * Note: It's important to use the same version of Java that powers Intellij. We don't want to develop a plugin using
     * Java 21 only to find out that Intellij can't run it because Intellij uses Java 17.
     *
     * See https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html
     */
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

intellij {
    version.set("2024.1")
}
