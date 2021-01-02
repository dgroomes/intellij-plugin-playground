# intellij-plugin-playground

📚 Learning and exploring Intellij IDEA plugin development.

## Design

This project implements a simple "Hello World" Intellij plugin in the `plugin/` sub-project.

What does this plugin do? When the plugin is enabled in Intellij, it creates a ["Tool window"](https://jetbrains.org/intellij/sdk/docs/user_interface_components/tool_windows.html)
that simply says "Hello World".

## Instructions

* `./gradlew runIde`
  * This will start a new instance of Intellij Community Edition with the plugin installed and enabled. This is a super
    convenient task provided by the `gradle-intellij-plugin` Gradle plugin.

## TODO

* DONE clean up scaffolded gradle project
* DONE Runnable "do-nothing" junit tests 
* DONE First commit
* DONE link to referenced materials (Intellij SDK docs)
* DONE Wire in some plugin boilerplate build stuff (Gradle, xml files, not really sure where to start...) 
* DONE implement a "hello world" plugin
* DONE Make the plugin behavior interactive. For example, it could respond to click events.

### Reference materials

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
