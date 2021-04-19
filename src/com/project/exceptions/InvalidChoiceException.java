package com.project.exceptions;

public class InvalidChoiceException extends Exception {

    public InvalidChoiceException() {
        super("Invalid choice selected.");
    }

    public InvalidChoiceException(String message) {
        super(message);
    }
}
