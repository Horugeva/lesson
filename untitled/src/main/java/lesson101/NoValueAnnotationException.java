package lesson101;

public class NoValueAnnotationException extends RuntimeException {
    public NoValueAnnotationException(String message) {
        super(message);
    }

    public NoValueAnnotationException() throws NoValueAnnotationException {
        throw new NoValueAnnotationException("NoValueAnnotationException");
    }
}