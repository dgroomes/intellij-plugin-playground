plugins {
    `java-library`
    id("org.jetbrains.intellij") version "0.6.5" // latest release: https://github.com/JetBrains/gradle-intellij-plugin/releases
}

repositories {
    mavenLocal()
    jcenter()
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html

dependencies {
    // SLF4J is already present in Intellij at runtime
    compileOnly("org.slf4j:slf4j-api:$slf4jVersion")
}

java {

    /**
     * Use Java 11
     * Note: It's important to use the same version of Java that powers Intellij. We don't want to develop a plugin using
     * Java 15 only to find out that Intellij can't run it because Intellij uses Java 11.
     */
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

intellij {

    /**
     * When I try "2020.3" or "2020.3.1" it throws a Kotlin-related exception. I dont' know why.
     */
    version = "2020.2"
}
