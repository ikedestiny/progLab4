package Model.Exceptions;

public class noObjectException extends RuntimeException {

    //this is an unchecked exception thrown at runtime when we try to interact with an object that has not been instantiated
    public noObjectException(String message) {
        super(message);
    }
}
