package common.exceptions;

public class OrderingException extends RuntimeException {
    public OrderingException(){
        super("Wrong ordering!");
    }
}
