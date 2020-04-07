package lesson11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class SausageService {

    public List<Sausage> getListSausageFromFile() throws IOException {
        return Files.lines(Paths.get("File.txt"))
                .map(line -> new String(Base64.getDecoder().decode(line)))
                .map(line -> {
                    String[] strings = line.split(", ");
                    return new Sausage(
                            strings[0].split("=")[1].replace("'", ""),
                            Integer.parseInt(strings[1].split("=")[1]),
                            Integer.parseInt(strings[2].split("=")[1]));
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        Logger logger = LoggerFactory.getLogger(SausageService.class);
        SausageService sausageService = new SausageService();
        logger.info("File: " + sausageService.getListSausageFromFile());
    }
}
