# intellij-plugin-playground

📚 Learning and exploring Intellij IDEA plugin development.


## Standalone subprojects

This repository illustrates different concepts, patterns and examples via standalone subprojects. Each subproject is
completely independent of the others and do not depend on the root project. This _standalone subproject constraint_
forces the subprojects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The subprojects include:


### `hello-world-plugin/`

A simple "Hello World" Intellij plugin.

See the README in [hello-world-plugin/](hello-world-plugin/).


# Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Update this project for 2023.
* [ ] (UPDATE: I made a lot of progress. Putting it in a branch for now) Can I make a plugin that extends the [HTTP client support in Intellij](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)?
  The HTTP client tooling in Intellij (e.g. `.http` files) is more sophisticated than I knew and I get the impression
  that it's more polished than I would have expected. They added lots more features in the Intellij IDEA 2023.2 release.
  The momentum is strong. I really like Insomnia, but I've always struggled to share HTTP requests with others. If I can
  use Intellij for what I use Insomnia for, I'd be happy to switch because then I can simply version control my HTTP
  requests (text is king (as much as it's painful to admit)) and share them with others. The feature I'm not sure about
  is "low friction and secure access key management". I need to be able to use the HTTP client tooling in Intellij and
  not have to worry about accidentally committing my credentials and not have to hassle with manually copy/pasting my
  credentials too much (Insomnia's Auth tab is amazing). Can I create an Intellij plugin that injects the HTTP client
  state with something (like a credential)? I kind of doubt it. UPDATE: yes it's totally possible.
   * DONE Scaffold a `http-client-enricher-for-github-plugin` subproject. This will showcase an Intellij plugin that works with the HTTP
     client plugin and adds customizations and quality-of-life improvements when interacting with the GitHub API.
     Specifically, I want the plugin prompt you for a personal access token (or maybe save it to some kind of Intellij
     credential store? That might be pushing it.)
   * DONE Rename the `plugin` project to `hello-world-plugin` to disambiguate it. And use the "Standalone subprojects" motto.
   * Create an example `.http` request (or a few) to the GitHub API
   * Prompt the user to enter a PAT (a modal?)
   * Set the PAT into the system so that it's available to the HTTP request. What are the "lifecycle choices"? Where are the idiomatic places to plug-in to the lifecycle of the request, or maybe
     the lifecycle of just opening the project? Can the JavaScript part of the lifecycle (pre-request handler) actually
     callback into Java or is that too late?
   * Does intellisense work on the variables? They should autocomplete and/or not be yellow highlighted as if they are a
     mistake.
* [x] DONE clean up scaffolded gradle project
* [x] DONE Runnable "do-nothing" junit tests 
* [x] DONE First commit
* [x] DONE link to referenced materials (Intellij SDK docs)
* [x] DONE Wire in some plugin boilerplate build stuff (Gradle, xml files, not really sure where to start...) 
* [x] DONE implement a "hello world" plugin
* [x] DONE Make the plugin behavior interactive. For example, it could respond to click events.


## Reference

* [Official docs: *IntelliJ Platform SDK*](https://jetbrains.org/intellij/sdk/docs)
* [*JShell: "Use classpath of" doesn't work*](https://youtrack.jetbrains.com/issue/IDEA-176418)
  * This bug/feature-request is my motivation for learning about Intellij plugins. In theory, I should be able to make a
    naive (i.e. something simple that doesn't really bring a lot of value necessarily!) plugin that integrates JShell in
    Intellij 
* [Official example repo: `intellij-sdk-code-samples`](https://github.com/JetBrains/intellij-sdk-code-samples)
  * This is a great resource of working examples. Run them yourself and learn from them!
* [Official Gradle Intellij plugin](https://github.com/JetBrains/gradle-intellij-plugin/)
  * This should be used to build your own Intellij IDE plugin.
