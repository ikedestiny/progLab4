package Exceptions;

//Unchecked exception
public class NoObjectException extends RuntimeException {

    //this is an unchecked exception thrown at runtime when we try to interact with an object that has not been instantiated
    public NoObjectException(String message) {
        super(message);
    }
}
