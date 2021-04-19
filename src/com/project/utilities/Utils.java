package com.project.utilities;

public class Utils {

    public static String pad(String inputString, int length, char paddingCharacter, boolean isLeftPad) {
        if (inputString.length() >= length) {
            return inputString;
        }

        StringBuilder sb = new StringBuilder(inputString);
        while (sb.length() < length - inputString.length()) {
            if (isLeftPad) {
                sb.insert(0, paddingCharacter);
            } else {
                sb.append(paddingCharacter);
            }
        }

        return sb.toString();
    }

    public static String rightPad(String inputString) {
        return pad(inputString, 50, ' ', false);
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
