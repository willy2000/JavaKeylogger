# Java Keylogger 
## Description
A simple implementation of a keylogger in Java. It is usable on Windows and with a german keyboard. This was part of a project for my Cybersecurity class in university. 
The implementation is not 100% complete (some keys could be missing) but it should be good enough to get an idea about keylogger.
## Requirements
- Windows System (not tested on a Unix system yet)
- Keyboard with german layout
- RethinkDB to get the keystrokes (including the Java library)
- JNativeHook library
## Build JAR executable
In order to build a .jar executable file run the following command (you will need to have maven installed):
```bash
mvn clean install
```
This will create a directory called target. In this you will find the keylogger-jar-with-dependencies.jar.

**Disclaimer: This software is provided ONLY for educational purposes and does not constitute an inducement to commit fraud.
If you use this software for any illegal purpose, the author is NOT responsible for your actions or any damage that may result from your actions.**
