package lesson101;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(Main.class);
        // FileService fileService = new FileService();
        // fileService.randomGenerationTxtFile();  //проверка на запись в файл
        //  fileService.getDataFromTxtFile("file.txt");  //проверка на создание сущностей из файла

        HumanEntity humanEntity = new HumanEntity();  //проверка на наличие аннотаций
        HumanValue humanValue = new HumanValue();
        CheckObject checkObject = new CheckObject();
        // while (true) {
        try {
            checkObject.check(humanEntity);
        } catch (IllegalStateException | NoValueAnnotationException | IllegalAccessException ignored) {
        }
        logger.info(humanEntity.getName() + " " + humanEntity.getAge());
        // }
    }
}

