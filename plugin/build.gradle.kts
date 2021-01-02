plugins {
    `java-library`
    id("org.jetbrains.intellij") version "0.6.5" // latest release: https://github.com/JetBrains/gradle-intellij-plugin/releases
}

repositories {
    mavenLocal()
    jcenter()
}

val slf4jVersion = "1.7.30" // releases: http://www.slf4j.org/news.html
val junitJupiterVersion = "5.7.0" // releases: https://junit.org/junit5/docs/current/release-notes/index.html
val assertJVersion = "3.18.1" // releases: https://github.com/assertj/assertj-core/releases

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    testRuntimeOnly("org.slf4j:slf4j-simple:$slf4jVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
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

tasks {

    withType(Test::class.java) {
        useJUnitPlatform()

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}
