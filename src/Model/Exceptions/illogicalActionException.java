package Model.Exceptions;

public class illogicalActionException extends Exception {
    ///a checked exception thrown when we try to do a step that requires a step before but the step gefore has not been  carried out
    public illogicalActionException(String message) {
        super(message);
    }
}
