package common.exceptions;

public class InvalidTargetException extends RuntimeException {
    public InvalidTargetException() {
        super("Invalid target position!");
    }
}
