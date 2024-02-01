package com.keylogger;

import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Stroke {

    public static final Map<Integer, String> simpleKeys = Stream.of(
        new Object[][] {
            // letters
            {NativeKeyEvent.VC_A, "a"},
            {NativeKeyEvent.VC_B, "b"},
            {NativeKeyEvent.VC_C, "c"},
            {NativeKeyEvent.VC_D, "d"},
            {NativeKeyEvent.VC_E, "e"},
            {NativeKeyEvent.VC_F, "f"},
            {NativeKeyEvent.VC_G, "g"},
            {NativeKeyEvent.VC_H, "h"},
            {NativeKeyEvent.VC_I, "i"},
            {NativeKeyEvent.VC_J, "j"},
            {NativeKeyEvent.VC_K, "k"},
            {NativeKeyEvent.VC_L, "l"},
            {NativeKeyEvent.VC_M, "m"},
            {NativeKeyEvent.VC_N, "n"},
            {NativeKeyEvent.VC_O, "o"},
            {NativeKeyEvent.VC_P, "p"},
            {NativeKeyEvent.VC_Q, "q"},
            {NativeKeyEvent.VC_R, "r"},
            {NativeKeyEvent.VC_S, "s"},
            {NativeKeyEvent.VC_T, "t"},
            {NativeKeyEvent.VC_U, "u"},
            {NativeKeyEvent.VC_V, "v"},
            {NativeKeyEvent.VC_W, "w"},
            {NativeKeyEvent.VC_X, "x"},
            {NativeKeyEvent.VC_Y, "y"},
            {NativeKeyEvent.VC_Z, "z"},
            // numbers
            {NativeKeyEvent.VC_1, "1"},
            {NativeKeyEvent.VC_2, "2"},
            {NativeKeyEvent.VC_3, "3"},
            {NativeKeyEvent.VC_4, "4"},
            {NativeKeyEvent.VC_5, "5"},
            {NativeKeyEvent.VC_6, "6"},
            {NativeKeyEvent.VC_7, "7"},
            {NativeKeyEvent.VC_8, "8"},
            {NativeKeyEvent.VC_9, "9"},
            {NativeKeyEvent.VC_0, "0"},
            // special keys
            {NativeKeyEvent.VC_ENTER, "[ENTER]"},
            {NativeKeyEvent.VC_TAB, "[TAB]"},
            {NativeKeyEvent.VC_SPACE, "[SPACE]"},
            {NativeKeyEvent.VC_BACKSPACE, "[BACKSPACE]"},
            {NativeKeyEvent.VC_CAPS_LOCK, "[CAPS LOCK]"},
            {NativeKeyEvent.VC_SHIFT, "[SHIFT]"},
            {NativeKeyEvent.VC_CONTROL, "[CTRL]"},
            {NativeKeyEvent.VC_ALT, "[ALT]"},
            {NativeKeyEvent.VC_DELETE, "[DEL]"},
            {NativeKeyEvent.VC_ESCAPE, "[ESC]"},
            {NativeKeyEvent.VC_F1, "[F1]"},
            {NativeKeyEvent.VC_F2, "[F2]"},
            {NativeKeyEvent.VC_F3, "[F3]"},
            {NativeKeyEvent.VC_F4, "[F4]"},
            {NativeKeyEvent.VC_F5, "[F5]"},
            {NativeKeyEvent.VC_F6, "[F6]"},
            {NativeKeyEvent.VC_F7, "[F7]"},
            {NativeKeyEvent.VC_F8, "[F8]"},
            {NativeKeyEvent.VC_F9, "[F9]"},
            {NativeKeyEvent.VC_F10, "[F10]"},
            {NativeKeyEvent.VC_UP, "[UP]"},
            {NativeKeyEvent.VC_DOWN, "[DOWN]"},
            {NativeKeyEvent.VC_LEFT, "[LEFT]"},
            {NativeKeyEvent.VC_RIGHT, "[RIGHT]"},
            // other characters
            {NativeKeyEvent.VC_SLASH, "/"},
            {NativeKeyEvent.VC_PRINTSCREEN, "*"},   // I don' know what this is
            {3658, "+"},
            {3662, "-"},
            {NativeKeyEvent.VC_SEPARATOR, ","},
            {NativeKeyEvent.VC_OPEN_BRACKET, "[ESZETT]"},
            {NativeKeyEvent.VC_CLOSE_BRACKET, "[ACUTE ACCENT]"},
            {NativeKeyEvent.VC_MINUS, "-"},
            {NativeKeyEvent.VC_EQUALS, "+"}
        })
        .collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        public static final Map<Integer, String> shiftKeys = Stream.of(
        new Object[][] {
            // letters
            {NativeKeyEvent.VC_A, "A"},
            {NativeKeyEvent.VC_B, "B"},
            {NativeKeyEvent.VC_C, "C"},
            {NativeKeyEvent.VC_D, "D"},
            {NativeKeyEvent.VC_E, "E"},
            {NativeKeyEvent.VC_F, "F"},
            {NativeKeyEvent.VC_G, "G"},
            {NativeKeyEvent.VC_H, "H"},
            {NativeKeyEvent.VC_I, "I"},
            {NativeKeyEvent.VC_J, "J"},
            {NativeKeyEvent.VC_K, "K"},
            {NativeKeyEvent.VC_L, "L"},
            {NativeKeyEvent.VC_M, "M"},
            {NativeKeyEvent.VC_N, "N"},
            {NativeKeyEvent.VC_O, "O"},
            {NativeKeyEvent.VC_P, "P"},
            {NativeKeyEvent.VC_Q, "Q"},
            {NativeKeyEvent.VC_R, "R"},
            {NativeKeyEvent.VC_S, "S"},
            {NativeKeyEvent.VC_T, "T"},
            {NativeKeyEvent.VC_U, "U"},
            {NativeKeyEvent.VC_V, "V"},
            {NativeKeyEvent.VC_W, "W"},
            {NativeKeyEvent.VC_X, "X"},
            {NativeKeyEvent.VC_Y, "Y"},
            {NativeKeyEvent.VC_Z, "Z"},
            // numbers
            {NativeKeyEvent.VC_1, "!"},
            {NativeKeyEvent.VC_2, "\""},
            {NativeKeyEvent.VC_3, "§"},
            {NativeKeyEvent.VC_4, "$"},
            {NativeKeyEvent.VC_5, "%"},
            {NativeKeyEvent.VC_6, "&"},
            {NativeKeyEvent.VC_7, "/"},
            {NativeKeyEvent.VC_8, "("},
            {NativeKeyEvent.VC_9, ")"},
            {NativeKeyEvent.VC_0, "="},
            // other characters
            {NativeKeyEvent.VC_OPEN_BRACKET, "?"},
            {NativeKeyEvent.VC_CLOSE_BRACKET, "`"},
            {NativeKeyEvent.VC_MINUS, "_"},
            {NativeKeyEvent.VC_EQUALS, "*"}
        })
        .collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

        public static final Map<Integer, String> altGrKeys = Stream.of(
        new Object[][] {
            // letters
            {NativeKeyEvent.VC_E, "[EURO SIGN]"},
            {NativeKeyEvent.VC_M, "[Greek mu]"},
            {NativeKeyEvent.VC_Q, "[@]"},
            // numbers
            {NativeKeyEvent.VC_2, "[High 2]"},
            {NativeKeyEvent.VC_3, "[High 3]"},
            {NativeKeyEvent.VC_7, "{"},
            {NativeKeyEvent.VC_8, "["},
            {NativeKeyEvent.VC_9, "]"},
            {NativeKeyEvent.VC_0, "}"},
            // other characters
            {NativeKeyEvent.VC_OPEN_BRACKET, "\\"},
        })
        .collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

    private String key;
    private String timestamp;

    public Stroke(String key, String timestamp) {
        this.key = key;
        this.timestamp = timestamp;
    }

    public String getKey() {
        return key;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
