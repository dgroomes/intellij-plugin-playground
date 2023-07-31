# http-client-enricher-for-github-plugin

NOT YET IMPLEMENTED

An Intellij plugin that enriches the [HTTP Client plugin](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html) when interacting with the GitHub API.


# Overview

This project is a step up from a "hello world" Intellij plugin because it has more sophisticated integration. This plugin
codes to the Java API's of the HTTP Client plugin, which is a little tenuous because the HTTP Client plugin is not
advertised for extension. However, this is a good showcase of the rich opportunities that we have with Intellij plugins.


## Instructions

Follow these instructions to build and use the plugin:

1. Use Java 17
2. Build the plugin and run it
   * ```shell
     ./gradlew runIde
     ```
   * This will start a new instance of Intellij Ultimate Edition with the plugin installed and enabled. This is a super
     convenient task provided by the `gradle-intellij-plugin` Gradle plugin.


## Reference

* [IntelliJ Platform Plugin SDK: *Plugin Dependencies*](https://plugins.jetbrains.com/docs/intellij/plugin-dependencies.html)
