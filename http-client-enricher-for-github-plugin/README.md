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


# Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [ ] Consider using Kotlin for plugin source code. Because Kotlin is already bundled, and because Kotlin is literally created and
  maintained by JetBrains, then using it in a JetBrains IDE plugin seems natural. Also, there are some Kotlin-specific
  APIs which use coroutines and other Kotlin-specific features. I don't want to go against the grain and use Java if
  JetBrains have made it a point to use Kotlin in the IDE APIs.
* [x] DONE Scaffold a `http-client-enricher-for-github-plugin` subproject. This will showcase an Intellij plugin that works with the HTTP
  client plugin and adds customizations and quality-of-life improvements when interacting with the GitHub API.
  Specifically, I want the plugin prompt you for a personal access token (or maybe save it to some kind of Intellij
  credential store? That might be pushing it.)
* [x] DONE Rename the `plugin` project to `hello-world-plugin` to disambiguate it. And use the "Standalone subprojects" motto.
* [x] DONE Create an example `.http` request (or a few) to the GitHub API
* [ ] Prompt the user to enter a PAT (a modal?)
* [ ] Set the PAT into the system so that it's available to the HTTP request.
* [x] DONE (Not necessarily the best implementation but much better than before) What are the "lifecycle choices"? Where are the idiomatic places to plugin to the lifecycle of the request, or maybe
  the lifecycle of just opening the project? Can the JavaScript part of the lifecycle (pre-request handler) actually
  callback into Java or is that too late?
* [ ] Does intellisense work on the variables? They should autocomplete and/or not be yellow highlighted as if they are a
  mistake.


## Reference

* [IntelliJ Platform Plugin SDK: *Plugin Dependencies*](https://plugins.jetbrains.com/docs/intellij/plugin-dependencies.html)
