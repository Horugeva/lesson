package lesson5;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConverterArgument {
    private Logger logger = LoggerFactory.getLogger(ConverterArgument.class);
    public Argument creatArgument(String[] words) {
        logger.info("Распознавание команды");
        StringBuilder text = new StringBuilder();
        Argument argument = new Argument();

        try {
            argument.setCommand(words[0]);
            try {
                argument.setLine(Integer.parseInt(words[1]));
            } catch (Exception e) {
                argument.setFileName(words[1]);
            }
            if (argument.getFileName() == null) {
                argument.setFileName(words[2]);
            }
            if (argument.getLine() == 0) {
                for (int i = 2; i < words.length; i++) {
                    words[i] = words[i].replace("\"", "");

                    text.append(words[i]).append(" ");
                }
            } else {
                for (int i = 3; i < words.length; i++) {
                    words[i] = words[i].replace("\"", "");
                    text.append(words[i]).append(" ");
                }
            }
            argument.setText(text.toString());
        }catch (Exception e){
            logger.debug("Ошибка конвертации входных параметров с консоли");
            throw new ConverterException();
        }
        logger.info("Команда распознана");
        return argument;

    }
}
