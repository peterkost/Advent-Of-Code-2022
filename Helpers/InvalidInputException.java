package Helpers;

public class InvalidInputException extends Exception {
    public InvalidInputException(String errorMessage) {
        super("Error in input file: " + errorMessage);
    }
}
