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
* link to referenced materials (Intellij SDK docs)
* implement a "hello world" plugin
