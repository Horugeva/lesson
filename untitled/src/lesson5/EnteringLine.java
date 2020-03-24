package lesson5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

public class EnteringLine {
    public static void main(String[] args) throws IOException, CommandExecutionException {
        Logger logger = LoggerFactory.getLogger(Delete.class);
        logger.info("Ввод строки");
        ConverterArgument converterArgument = new ConverterArgument();
        FilterCommand filterCommand = new FilterCommand();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду ");
            String command = input.nextLine();
            String[] words = command.split("\\s");
            Argument argument = converterArgument.creatArgument(words);
            filterCommand.handle(argument);
        }
    }
}
