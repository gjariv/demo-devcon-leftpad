package com.github.gjariv.leftpad;

public class LeftPad {
    private static String leftPad(String str, int len, String ch) {
        if (len <= str.length()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = str.length(); i < len; i++) {
            sb.append(ch);
        }

        sb.append(str);

        return sb.toString();
    }

    public static String leftPad(String str, int len) {
        return leftPad(str, len, " ");
    }

    public static String leftPad(String str, int len, char ch) {
        return leftPad(str, len, Character.toString(ch));
    }

    public static String leftPad(String str, int len, long ch) {
        return leftPad(str, len, Long.toString(ch));
    }

    public static String leftPad(String str, int len, double ch) {
        return leftPad(str, len, Double.toString(ch));
    }

    public static String leftPad(String str, int len, Object ch) {
        return leftPad(str, len, ch.toString());
    }
}