# intellij-plugin-playground

📚 Learning and exploring Intellij IDEA plugin development.


## Overview

This project implements a simple "Hello World" Intellij plugin in the `plugin/` sub-project.

What does this plugin do? When the plugin is enabled in Intellij, it creates a ["Tool window"](https://jetbrains.org/intellij/sdk/docs/user_interface_components/tool_windows.html)
that simply says "Hello World".


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

* [x] DONE Update this project for 2023.
* [ ] Can I make a plugin that extends the [HTTP client support in Intellij](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)?
  The HTTP client tooling in Intellij (e.g. `.http` files) is more sophisticated than I knew and I get the impression
  that it's more polished than I would have expected. They added lots more features in the Intellij IDEA 2023.2 release.
  The momentum is strong. I really like Insomnia, but I've always struggled to share HTTP requests with others. If I can
  use Intellij for what I use Insomnia for, I'd be happy to switch because then I can simply version control my HTTP
  requests (text is king (as much as it's painful to admit)) and share them with others. The feature I'm not sure about
  is "low friction and secure access key management". I need to be able to use the HTTP client tooling in Intellij and
  not have to worry about accidentally committing my credentials and not have to hassle with manually copy/pasting my
  credentials too much (Insomnia's Auth tab is amazing). Can I create an Intellij plugin that injects the HTTP client
  state with something (like a credential)? I kind of doubt it.
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
* [Official Intellij Gradle plugin](https://github.com/JetBrains/gradle-intellij-plugin/)
  * This should be used to build your own Intellij IDE plugin.
* [The Java Tutorials: *Creating a GUI With JFC/Swing*](https://docs.oracle.com/javase/tutorial/uiswing/)
* [Intellij docs: *GUI Designer Basics*](https://www.jetbrains.com/help/idea/gui-designer-basics.html)
  * The Intellij GUI Designer is used for authoring the GUI components of an Intellij plugin (technically, I don't think
    it is required, but naturally, the Intellij GUI Designer is effective for making Intellij plugins :smile:).
