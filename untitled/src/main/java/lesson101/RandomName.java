package lesson101;

import java.util.Random;

public class RandomName {
    public String generateRandomName() {
        Random random = new Random();
        char[] nameEntity = new char[random.nextInt(8) + 3];
        for (int j = 0; j < nameEntity.length; j++) {
            nameEntity[j] = (char) ('a' + random.nextInt(26));
        }
        return new String("name=" + nameEntity);
    }
}
