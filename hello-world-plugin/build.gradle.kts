plugins {
    `java-library`
    alias(libs.plugins.intellij.platform.gradle.plugin)
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    // SLF4J is already present in Intellij at runtime, so we only need it at compile time
    compileOnly(libs.slf4j.api)

    // During our development workflow, we can run our plugin in an IntelliJ instance that's separate from the IntelliJ
    // we're developing in. The IntelliJ Platform Gradle Plugin provides a dependencies extension to describe the IDE
    // (i.e. Community or Ultimate; version; etc.) that we want to use for this, and all the other dependencies we need
    // from IntelliJ.
    //
    // See https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        intellijIdeaCommunity("2024.2")
        instrumentationTools()
    }
}

java {

    /**
     * Note: It's important to use the same version of Java that powers Intellij. We don't want to develop a plugin using
     * Java 22 only to find out that Intellij can't run it because Intellij uses Java 21.
     *
     * See https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html
     */
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}
