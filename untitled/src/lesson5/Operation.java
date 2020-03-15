package lesson5;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Operation {
    void handle(String command, int line, String file, String text) throws IOException, CommandExecutionException;
}
