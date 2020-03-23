package lesson4test;

public class MapperException extends Exception {
    public MapperException(String message) {
        super(message);
    }

    public MapperException() throws MapperException {
        throw new MapperException("MapperException");
    }
}