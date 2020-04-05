package lesson11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Collectors;

public class FileService {
        private Logger logger = LoggerFactory.getLogger(FileService.class);
    public void fileWriter() {
        CollectionStream collectionStream = new CollectionStream();
        try {
            Files.write(Paths.get("file15.txt"), collectionStream.generateListUuid()
                    .stream()
                    .map(UUID::toString)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            logger.info("file writer");
            e.printStackTrace();
        }
    }

    public long fileReader(){
        try {
            long count = Files.lines(Paths.get("file15.txt"))
                    .map(uuid -> uuid.replaceAll(("[^0-9 ]"), ""))
                    .map(uuidOnlyNumbers -> uuidOnlyNumbers.chars().map(Character::getNumericValue).sum())
                    .filter(sum -> sum > 120)
                    .count();

            logger.info("file reader. Total UUID elements with the sum of digits > 100: " + count);

            return count;
        } catch (IOException e) {
        }
        return 0;
    }



    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.fileWriter();
        fileService.fileReader();
    }
}
