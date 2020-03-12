package lesson4;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String message) {
        super(message);
    }
    public RepositoryException() throws RepositoryException {
            throw new RepositoryException("RepositoryException");
        }
    }
