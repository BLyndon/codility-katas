package common.exceptions;

public class DuplicateValueException extends RuntimeException{
    public DuplicateValueException (){
        super("Values are not distinct!");
    }
}
