package lesson4;

public class EntityCreationException extends RuntimeException {
    public EntityCreationException(String message) {
        super(message);
    }

    public EntityCreationException() throws EntityCreationException {
        throw new EntityCreationException("EntityCreationError");
    }
}
