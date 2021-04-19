package com.project.utilities;

public class Utils {

    public static final int ID = 1, FULL_NAME = 2, EMPLOYEE_TYPE = 3, GROSS_SALARY = 4, INCOME_TAX = 5, HEALTH_FEE = 6, NET_SALARY = 7;

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

    public static String rightPad(String inputString, int length, char character) {
        return pad(inputString, length, character, false);
    }

    public static String rightPad(String inputString, int length) {
        return pad(inputString, length, ' ', false);
    }

    public static String centerPad(String inputString, int length, char paddingCharacter) {
        if (inputString.length() >= length) return inputString;
        int padding = (length - inputString.length()) / 2;
        StringBuilder sb = new StringBuilder(inputString);
        sb.insert(0, pad("", padding, '*', true));
        sb.append(pad("", padding, '*', false));
        return sb.toString();
    }

    public static String getPaddedString(String inputString, int type) {
        String string = "";
        switch (type) {
            case ID:
            case GROSS_SALARY:
            case INCOME_TAX:
            case HEALTH_FEE:
            case NET_SALARY:
                string += rightPad(inputString, 5);
                break;
            case FULL_NAME:
                string += rightPad(inputString, 30);
                break;
            case EMPLOYEE_TYPE:
                string += rightPad(inputString, 15);
                break;
            default:
                string += inputString;
        }
        string += " ";
        return string;
    }
}
