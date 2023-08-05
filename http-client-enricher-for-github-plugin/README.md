# http-client-enricher-for-github-plugin

NOT YET IMPLEMENTED (Note: this subproject needs to be split up. See the notes in the wish list.)

An Intellij plugin that enriches the [HTTP Client plugin](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html) when interacting with the GitHub API.


# Overview

This project is a step up from a "hello world" Intellij plugin because it has more sophisticated integration. This plugin
codes to the APIs of the HTTP Client plugin, which is a little tenuous because the HTTP Client plugin is not
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

* [x] DONE Consider using Kotlin for plugin source code. Because Kotlin is already bundled, and because Kotlin is literally created and
  maintained by JetBrains, then using it in a JetBrains IDE plugin seems natural. Also, there are some Kotlin-specific
  APIs which use coroutines and other Kotlin-specific features. I don't want to go against the grain and use Java if
  JetBrains have made it a point to use Kotlin in the IDE APIs.
   * Found a doc: [*Configuring Kotlin Support*](https://plugins.jetbrains.com/docs/intellij/using-kotlin.html)
* [x] DONE Scaffold a `http-client-enricher-for-github-plugin` subproject. This will showcase an Intellij plugin that works with the HTTP
  client plugin and adds customizations and quality-of-life improvements when interacting with the GitHub API.
  Specifically, I want the plugin prompt you for a personal access token (or maybe save it to some kind of Intellij
  credential store? That might be pushing it.)
* [x] DONE Rename the `plugin` project to `hello-world-plugin` to disambiguate it. And use the "Standalone subprojects" motto.
* [x] DONE Create an example `.http` request (or a few) to the GitHub API
* [ ] Explore how to intercept and change the request right before it gets executed. I'm thinking that for a request
  definition (`.http`) to GitHub, when it gets executed, the plugin should intercept the request and inject the PAT into
   * `com.intellij.httpClient.execution.impl.HttpRequestHandler.prepareExecutionEnvironment` this is interesting. But how
     do I inject my own HttpRequestHandler?
  it as a header.
* [ ] Prompt the user to enter a PAT (a modal?)
* [ ] Set the PAT into the system so that it's available to the HTTP request.
* [x] DONE (Not necessarily the best implementation but much better than before) What are the "lifecycle choices"? Where are the idiomatic places to plugin to the lifecycle of the request, or maybe
  the lifecycle of just opening the project? Can the JavaScript part of the lifecycle (pre-request handler) actually
  callback into Java or is that too late?
* [ ] Does intellisense work on the variables? They should autocomplete and/or not be yellow highlighted as if they are a
  mistake.
* [x] DONE Use `com.intellij.openapi.startup.ProjectActivity`
* [ ] Deconstruct this plugin into smaller plugins. This has gotten too rich because of the added complexity of GraphQL
  plus the added complexity of the GitHub API being authenticated. But I've learned some good things along the way.
  Breaking out the pure HTTP Client plugin *usage* into a subproject in my `intellij-playground` would be nice. And then
  breaking out the HTTP Client plugin *extension plugin* into something small like maybe a "content encoding preferences"
  plugin which just adds a `Accept-Encoding: gzip` header to all requests transparently would be nice (and not even sure
  how possible it is because the "request execution support" stuff is a bit rigid...)


## Reference

* [IntelliJ Platform Plugin SDK: *Plugin Dependencies*](https://plugins.jetbrains.com/docs/intellij/plugin-dependencies.html)
* [JetBrains plugin marketplace: *HTTP Client*](https://plugins.jetbrains.com/plugin/13121-http-client)
* [`graphql-config-examples`](https://github.com/jimkyndemeyer/graphql-config-examples/tree/master/github-api-v4)
  * This is a nice discovery. The Intellij GraphQL plugin is quite rich and is actually still mostly a third-party plugin
    (although it's so important that it's hosted in the JetBrains GitHub org and I imagine JetBrains developers contribute
    to it). The linked page shows just how "ready-to-use" this plugin is because it give a working example of how to
    configure your project to do an introspection against the GitHub GraphQL schema which has the extra wrinkle that
    even doing an introspection query is authenticated.
