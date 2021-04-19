package com.project.utilities;

public class Utils {

    public static final int LEFT_HEADING_LENGTH = 25,
            LEFT_TEXT_LENGTH = 45;

    public static String pad(String inputString, int n, char paddingChar, boolean isLeftPad) {
        if (isLeftPad) {
            return String.format("%" + n + "s", inputString).replace(' ', paddingChar);
        } else {
            return String.format("%-" + n + "s", inputString).replace(' ', paddingChar);
        }
    }

    public static String rightPad(String inputString) {
        return rightPad(inputString, 50);
    }

    public static String rightPad(String inputString, int n) {
        return pad(inputString, n, ' ', false);
    }

    public static String centerPad(String inputString, int length, char paddingCharacter) {
        if (inputString.length() >= length) return inputString;
        int padding = (length - inputString.length()) / 2;
        StringBuilder sb = new StringBuilder(inputString);
        sb.insert(0, pad("", padding, '*', true));
        sb.append(pad("", padding, '*', false));
        return sb.toString();
    }
}
