# shared-environment-variables-plugin

NOT YET IMPLEMENTED

An Intellij plugin for defining and sharing variables that can be used as environment variables in Intellij "Run Configurations".


# Overview

Basically, I want to be able to define a variable in one place and then use it in multiple places. This is especially
true for things like database connection strings. Yes, you can use actual [environment variables and make them available in Intellij](https://stackoverflow.com/questions/45696203/intellij-idea-global-environment-variable-configuration)
but there are idiosyncrasies with that approach. You need to understand what process is launching Intellij, the interaction
with the parent shell, (system vs user shell?), etc. And besides that, I want to reference a "secret" variable and use
it in multiple places. I want Intellij to be the manager for these values. You can already use Intellij to manage
database connections/password. Let's explore a way to do this via a simple plugin.


## Instructions

Follow these instructions to build and use the plugin:

1. Use Java 17
2. Build the plugin and run it
   * ```shell
     ./gradlew runIde
     ```
   * This will start a new instance of Intellij Community Edition with the plugin installed and enabled. This is a super
     convenient task provided by the `gradle-intellij-plugin` Gradle plugin.


# Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Scaffold
* [ ] IN PROGRESS Defect. When I have `SharedEnvVarsToolWindowFactory` under the `kotlin` source set, I get runtime errors like:
  * ```text
    Cannot process toolwindow Shared Env Vars:
    com.intellij.diagnostic.PluginException: dgroomes.SharedEnvVarsToolWindowFactory...
    ...
    Caused by: java.lang.ClassNotFoundException: dgroomes.SharedEnvVarsToolWindowFactory
    ```
  * Figure this out by studying another plugin, like <https://github.com/JetBrains/js-graphql-intellij-plugin>.
  * UPDATE: It's interesting. Open source plugins like JetBrains' own "Academy" plugin, the GraphQL Java plugin and the
    SonarLint plugin all use Java and Kotlin and all put the Java and Kotlin code in the same directory. SonarLink just
    puts its Kotlin code in the familiar `src/main/java` directory which seems like the least fussy way to do it, but
    on the other hand it can be a bit head-scratching to purposely go with a mislabelled directory. The other two plugin
    decide to redefine the source sets as just `src/` and `resources/`. I'm down for that. [Example](https://github.com/JetBrains/educational-plugin/blob/a15bccbe66bb4c6d9bccaf68d7e8a4668dc1b922/build.gradle.kts#L169).
    In general, the status quo (albeit verbose) is effective and consistent, but we're in learning and experimenting
    mode. Try new things.
  * Make sure Kotlin works. Convert dgroomes.SharedEnvVarsToolWindowFactory to Kotlin. 
* [ ] Do it.


## Reference

* [YouTrack KTIJ-791: *UIDesigner doesn't work with Kotlin classes*](https://youtrack.jetbrains.com/issue/KTIJ-791)
* [Intellij Platform Plugin SDK: *User Interface Components*](https://plugins.jetbrains.com/docs/intellij/user-interface-components.html)
  * UI dev using Swing is new to me (done it very sparingly before). I found that porting the "hello-world-plugin" to a
    Kotlin-based plugin project didn't work because of accepted non-support for Kotlin with the UI Designer (something I
    don't understand; but there is something called UI Inspector?)
