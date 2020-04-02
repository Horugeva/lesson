package lesson101;

import java.util.Random;

public class RandomAge {
    public int generateRandomAge() {
        Random random = new Random();
        return random.nextInt(50);
    }
}
