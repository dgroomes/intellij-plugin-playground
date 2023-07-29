plugins {
    `java-library`
    id("org.jetbrains.intellij") version "1.15.0" // Gradle Intellij Plugin releases: https://github.com/JetBrains/gradle-intellij-plugin/releases
}

repositories {
    mavenCentral()
}

val slf4jVersion = "2.0.7" // SLF4J releases: http://www.slf4j.org/news.html

dependencies {
    // SLF4J is already present in Intellij at runtime
    compileOnly("org.slf4j:slf4j-api:$slf4jVersion")
}

java {

    /**
     * Use Java 17
     * Note: It's important to use the same version of Java that powers Intellij. We don't want to develop a plugin using
     * Java 20 only to find out that Intellij can't run it because Intellij uses Java 17.
     */
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

intellij {
    version.set("2023.1.5")
}
