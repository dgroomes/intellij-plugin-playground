# hello-world-plugin

A simple "Hello World" Intellij plugin.


## Overview

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


## Reference

* [The Java Tutorials: *Creating a GUI With JFC/Swing*](https://docs.oracle.com/javase/tutorial/uiswing/)
* [Intellij docs: *GUI Designer Basics*](https://www.jetbrains.com/help/idea/gui-designer-basics.html)
  * The Intellij GUI Designer is used for authoring the GUI components of an Intellij plugin (technically, I don't think
    it is required, but naturally, the Intellij GUI Designer is effective for making Intellij plugins :smile:).
