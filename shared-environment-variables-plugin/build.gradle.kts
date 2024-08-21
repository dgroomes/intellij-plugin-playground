plugins {
    alias(libs.plugins.intellij.platform.gradle.plugin)
    alias(libs.plugins.kotlin.plugin)
}

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    // SLF4J is already present in the Intellij Platform at runtime, so we only need it at compile time
    compileOnly(libs.slf4j.api)

    intellijPlatform {
        intellijIdeaCommunity("2024.2")
        instrumentationTools()
    }
}

/*
In Java and Kotlin codebases, the default source set locations are:

    src/
    |-- main/
    |   |-- java/
    |   |-- kotlin/
    |   `-- resources/
    `-- test/
        |-- java/
        |-- kotlin/
        `-- resources/

But we're going to diverge a bit. Let's unnest and consolidate the source set directories:=

    src/
    resources/
    testSrc/
    testResources/

This is a bit unconventional but for some reason I think you need for the Java and Kotlin source code to be in the same
directory for the annotation processing (related to UI/Swing code) to work. I don't know why.
*/
sourceSets {
    main {
        java.srcDirs("src")
        resources.srcDirs("resources")
    }

    test {
        java.srcDirs("testSrc")
        resources.srcDirs("testResources")
    }
}

kotlin {
    sourceSets {
        main {
            kotlin.srcDirs("src")
        }
        test {
            kotlin.srcDirs("testSrc")
        }
    }
}

kotlin {
    jvmToolchain(21)
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
                languageVersion = "1.9"
            }
        }
    }
}
