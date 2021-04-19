package com.project.utilities;

public class Utils {

    public static String rightPad(String inputString, int length, char paddingCharacter) {
        if (inputString.length() >= length) {
            return inputString;
        }

        StringBuilder sb = new StringBuilder(inputString);
        while (sb.length() < length - inputString.length()) {
            sb.append(paddingCharacter);
        }

        return sb.toString();
    }

    public static String rightPad(String inputString, int length) {
        return rightPad(inputString, length, ' ');
    }

    public static String rightPad(String inputString) {
        return rightPad(inputString, 50, ' ');
    }
}
