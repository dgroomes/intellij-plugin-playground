# intellij-plugin-playground

NOT YET IMPLEMENTED

📚 Learning and exploring Intellij IDEA plugin development.

## Design

TBD (Not really sure how to structure it right now).

The core source code of the Intellij plugin is in the Gradle sub-project `plugin/`.

## Instructions

* Use Java 11
  * Note: It's important to use the same version of Java that powers Intellij. We don't want to developer a plugin using
    Java 15 only to find out that Intellij can't run it because Intellij uses Java 11.
* Run the tests with `./gradlew test`
* TBD

## TODO

* DONE clean up scaffolded gradle project
* DONE Runnable "do-nothing" junit tests 
* DONE First commit
* DONE link to referenced materials (Intellij SDK docs)
* Wire in some plugin boilerplate build stuff (Gradle, xml files, not really sure where to start...) 
* implement a "hello world" plugin

### Reference materials

* [Official docs: *IntelliJ Platform SDK*](https://jetbrains.org/intellij/sdk/docs)
* [*JShell: "Use classpath of" doesn't work*](https://youtrack.jetbrains.com/issue/IDEA-176418)
  * This bug/feature-request is my motivation for learning about Intellij plugins. In theory, I should be able to make a
    naive (i.e. something simple that doesn't really bring a lot of value necessarily!) plugin that integrates JShell in
    Intellij 
* [Official example repo: `intellij-sdk-code-samples`](https://github.com/JetBrains/intellij-sdk-code-samples)
  * Note: I haven't tried this yet but it seems like a great resource of executable examples.
