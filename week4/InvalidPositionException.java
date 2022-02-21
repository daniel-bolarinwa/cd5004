public class InvalidPositionException extends Exception {

    public InvalidPositionException() // constructor without parameter
    {
        super("Input should be between 0 and 3 inclusive");
    }

    public InvalidPositionException(String message) // constructor with parameter
    {
        super(message);
    }
}
