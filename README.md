# Simple Java Keylogger 
## Description
A simple implementation of a keylogger in Java. It is usable on Windows and with a german keyboard. This was part of a project for my Cybersecurity class in university. 
## Build JAR executable with maven
In order to build a .jar executable file run the following command inside the keylogger directory (you will need to have maven installed):
```bash
mvn package
```
This will create a directory called target. In this you will find the keylogger-jar-with-dependencies.jar.
## Modes
### Console
Print keystrokes and timestamp to console. Set in *Keylogger.java*:
```java
private static final Mode mode = Mode.CONSOLE;
```
### File
Print keystrokes and timestamp to a file. File name and path can be specified in *Keylogger.java*:
```java
private static final String FILE_PATH = "keystrokes.txt";
private static final Mode mode = Mode.FILE;
```
### Database
The keylogger uses RethinkDB to store keys and timestamps. In order to use this you will need to set up a connection to your RethinkDB-database. For demonstration I have a local installation. Please see documentation on https://rethinkdb.com/. 
```java
private static final String DB_NAME = <database name>;
private static final String DB_TABLE_NAME = <database table name>;
private static final String DB_HOST = <your host>;
private static final int DB_PORT = <port>;
private static final Mode mode = Mode.DATABASE;
```
First start RethinkDB, then start the keylogger. 

**Disclaimer: This software is provided ONLY for educational purposes and does not constitute an inducement to commit fraud. If you use this software for any illegal purpose, the author is NOT responsible for your actions or any damage that may result from your actions.**
