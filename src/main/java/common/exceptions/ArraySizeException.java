package common.exceptions;

public class ArraySizeException extends RuntimeException {
    public ArraySizeException() {
        super("Array size out of range!");
    }
}
