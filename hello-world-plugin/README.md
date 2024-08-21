# hello-world-plugin

A simple "Hello World" Intellij plugin.


## Overview

What does this plugin do? When the plugin is enabled in Intellij, it creates a ["Tool window"](https://jetbrains.org/intellij/sdk/docs/user_interface_components/tool_windows.html)
that simply says "Hello World".


## Instructions

Follow these instructions to build and use the plugin:

1. Pre-requisite: Java 21
   * 
2. Build the plugin and run it
   * ```shell
     ./gradlew runIde
     ```
   * This will start a new instance of Intellij Community Edition with the plugin installed and enabled. This is a super
     convenient task provided by the `gradle-intellij-plugin` Gradle plugin.


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Updates for 2024
* [x] DONE (Ok I upgraded my Intellij to 2024.2.0.2 so now I need to do this) Consider upgrading to [version 2.0 of the Intellij Gradle Plugin](https://github.com/JetBrains/intellij-platform-gradle-plugin/releases/tag/v2.0.0)
  The 2.0 version of the plugin is now called *Intellij Platform Gradle Plugin* instead of Gradle Intellij Plugin. Do
  not rush into this though, it is hot off the presses and is at the intersection of lots of software (IDE, build tool,
  language) so there will be rough edges. The 2.0 version coincides with [an upgrade to Java 21](https://plugins.jetbrains.com/docs/intellij/build-number-ranges.html)
  and other major changes  in the platform.
* [ ] Look into the "failed to run /usr/local/ .... shell " error. Very interesting. See [this page](https://intellij-support.jetbrains.com/hc/en-us/articles/15268184143890-Shell-Environment-Loading). 


## Reference

* [IntelliJ Platform docs: *IntelliJ Platform Gradle Plugin (2.x)*](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html)
* [The Java Tutorials: *Creating a GUI With JFC/Swing*](https://docs.oracle.com/javase/tutorial/uiswing/)
* [Intellij docs: *GUI Designer Basics*](https://www.jetbrains.com/help/idea/gui-designer-basics.html)
  * The Intellij GUI Designer is used for authoring the GUI components of an Intellij plugin (technically, I don't think
    it is required, but naturally, the Intellij GUI Designer is effective for making Intellij plugins :smile:).
