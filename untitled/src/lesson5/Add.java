package lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//add 5 fileName "text"   add 5 C:/1/Data.txt "ghbdtn ghtbv"
//- add команда на добавление текста.
//5 строка в файле (если в файле к примеру всего 3 строки, то необходимо будет добавить 2 строки).
//Так же строка которая раньше находилась под номером 5 должна стать номером 6 и т.д., короче все сдвигается вниз на одну строку
//fileName имя файла для редактирования
//"text" собственно текст который мы хотим добавить. Текст указывается в двойных кавычках.
//ВНИМАНИЕ, если мы не указываем номер строки, а к примеру даем команду add "text", то мы добавляем просто новую строку с текстом.
//Если номер строки не указан, то нужно просто добавить строку в конец файла.
//
public class Add implements Operation {
    private Logger logger = LoggerFactory.getLogger(Add.class);

    @Override
    public void handle(String command, int line, String file, String text) throws CommandExecutionException, IOException {
        logger.info("Добавление строки");
        List<String> list = Files.readAllLines(Paths.get("Data.txt"));
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
//throw new CommandException("CommandException");