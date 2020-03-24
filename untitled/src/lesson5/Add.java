package lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Add implements Operation {
    private Logger logger = LoggerFactory.getLogger(Add.class);

    @Override
    public void handle(String command, int line, String file, String text) throws CommandExecutionException, IOException {
        logger.info("Добавление строки");
        List<String> list = Files.readAllLines(Paths.get(file));
        try {
            if (line != 0) {
                generateEmptyRows(list, line);
                list.add(line - 1, text);
            } else {
                list.add(text);
            }
            Files.write(Paths.get("Data.txt"), list);
        } catch (Exception e) {
            logger.debug("Ошибка выполнения команды", e);
            throw new CommandExecutionException("CommandExecutionException");
        }
        logger.info("Строка добавлена");
    }

    private void generateEmptyRows(List list, int line) {
        if (list.size() < line) {
            for (int i = list.size(); i < line; i++) {
                list.add("");
            }
        }
    }
}
