package lesson101.src.service.impl;

import lesson101.Data;
import lesson101.RandomAge;
import lesson101.RandomName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileService {
    private Logger logger = LoggerFactory.getLogger(FileService.class);

    public List<Data> getDataFromTxtFile(String filePath) throws IOException {
        List<Data> dataList = new ArrayList<>();
        Path path = Paths.get(filePath);
        List<String> contents = Files.readAllLines(path);
        for (int i = 0; i < contents.size(); ) {
            Data data = new Data();
            if (contents.get(i).contains("name")) {
                data.setName(contents.get(i).substring(5));
            }
            if (contents.get(i + 1).contains("age")) {
                data.setAge(Integer.parseInt(contents.get(i + 1).substring(4)));
            }
            dataList.add(data);
            i = i + 2;
        }
        logger.info(String.valueOf(dataList));
        return dataList;
    }

    public void randomGenerationTxtFile() {
        try (FileWriter fileWriter = new FileWriter("file.txt")) {
            Random random = new Random();
            for (int i = 0; i < random.nextInt(8); i++) {
                fileWriter.write(generateRandomName("name"));
                fileWriter.write('\n');
                fileWriter.write(generateRandomAge("age"));
                fileWriter.write('\n');
                logger.info(generateRandomName("name"));
                logger.info(generateRandomAge("age"));
            }
        } catch (IOException e) {
        }
    }

    private String generateRandomName(String entity) {
        RandomName randomName = new RandomName();
        return randomName.generateRandomName();
    }

    private String generateRandomAge(String entity) {
        RandomAge randomAge = new RandomAge();
        return ("age=" + randomAge.generateRandomAge());
    }
}
