package lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//delete 5 fileName
//- delete команда на удаление строки
//5 номер строки которую нам необходимо удалить.
//ВНИМАНИЕ, если мы не указываем номер строки, а к примеру даем команду delete, то мы удаляем последнюю строку из файла.
//
public class Delete implements Operation {
    private Logger logger = LoggerFactory.getLogger(Delete.class);
    @Override
    public void handle(String command, int line, String file, String text) throws IOException, CommandExecutionException {
        logger.info("Удаление строки");
        List<String> list = Files.readAllLines(Paths.get("Data.txt"));
        try {

        if (line != 0 && list.size() >= line) {
            list.remove(line - 1);
        } else {
            list.remove(list.size() - 1);
        }
        } catch (Exception e) {
            logger.debug("Ошибка выполнения команды", e);
            throw new CommandExecutionException("CommandExecutionException");
        }
        logger.info("Строка удалена");
        Files.write(Paths.get("Data.txt"), list);

    }

}
