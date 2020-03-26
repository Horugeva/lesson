package lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class FilterCommand {
    private Operation operation;
    private Logger logger = LoggerFactory.getLogger(FilterCommand.class);
    private static final String EXCEPTION = "Произошло исключение ";

    public void handle(Argument argument) throws IOException, CommandExecutionException {
        logger.info("Выбор команды");
        if (argument.getCommand().equals("add")) {
            try {
                operation = new Add();
                operation.handle(argument.getCommand(), argument.getLine(), argument.getFileName(), argument.getText());
            } catch (CommandExecutionException e) {
                logger.debug(EXCEPTION, e);
            }
        } else if (argument.getCommand().equals("delete")) {
            try {
                operation = new Delete();
                operation.handle(argument.getCommand(), argument.getLine(), argument.getFileName(), argument.getText());
            } catch (CommandExecutionException e) {
                logger.debug(EXCEPTION, e);
            }
        } else if (argument.getCommand().equals("print")) {
            try {

                operation = new Print();
                operation.handle(argument.getCommand(), argument.getLine(), argument.getFileName(), argument.getText());
            } catch (CommandSelectionException e) {
                logger.debug(EXCEPTION, e);
            }
        } else {
            logger.info("Команда не существует: {}", argument.getCommand());
            throw new CommandSelectionException("Команда не существует");
        }
    }
}
