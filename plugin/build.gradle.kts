plugins {
    `java-library`
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

tasks {

    withType(Test::class.java) {
        useJUnitPlatform()

        testLogging {
            showStandardStreams = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}
