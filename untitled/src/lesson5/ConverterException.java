package lesson5;

public class ConverterException extends RuntimeException {
    public ConverterException(String message) {
        super(message);
    }
    public ConverterException() throws ConverterException {
        throw new ConverterException("ConverterException");
    }
}
