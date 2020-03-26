package lesson5;

import java.io.IOException;

public interface Operation {
    String file = "Data.txt";
    void handle(String command, int line, String file, String text) throws IOException, CommandExecutionException;
}
