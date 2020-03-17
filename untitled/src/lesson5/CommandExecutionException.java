package lesson5;

public class CommandExecutionException extends Exception {
    public CommandExecutionException(String message) {
        super(message);
    }

    public CommandExecutionException() throws CommandExecutionException {
        throw new CommandExecutionException("CommandExecutionException");
    }
}
