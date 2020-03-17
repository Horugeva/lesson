package lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//print 4 fileName
//- print команда на печать
//4 это номер строки которую мы хотим распечатать.
//ВНИМАНИЕ, если мы не указываем номер строки, а к примеру даем команду print, то мы печатаем весь файл.
public class Print implements Operation {
    private Logger logger = LoggerFactory.getLogger(Print.class);

    @Override
    public void handle(String command, int line, String file, String text) throws IOException, CommandExecutionException {
        logger.info("Печать строки");
        List<String> list = Files.readAllLines(Paths.get("Data.txt"));
        try {

            if (line > 0 && list.size() >= line) {
                System.out.println(list.get(line - 1));
            } else {
                for (String printLine : list) {
                    System.out.println(printLine);
                }
            }
        } catch (Exception e) {
            logger.debug("Ошибка выполнения команды", e);
            throw new CommandExecutionException("CommandExecutionException");
        }
        logger.info("Строка напечатана");
    }
}
