package Model.Exceptions;

//Unchecked exception
public class NoCoffeeMaker extends RuntimeException {
    public NoCoffeeMaker(String message) {
        super(message);
    }
}
