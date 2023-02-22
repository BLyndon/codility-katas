package common.exceptions;

public class ValueRangeException extends RuntimeException {
    public ValueRangeException () {
        super("Value out of range!");
    }
}
