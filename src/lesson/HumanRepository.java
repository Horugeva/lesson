package lesson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HumanRepository implements Repository<HumanEntity> {

    @Override
    public HumanEntity findUser(long id) {
        return createEntity();
    }

    @Override
    public List<HumanEntity> findAll() {
        createEntity();
        List<HumanEntity> humanEntityList = new ArrayList<>();
        humanEntityList.add(createEntity());
        return humanEntityList;
    }

    @Override
    public void save(HumanEntity humanEntity) {
        System.out.println(humanEntity);
    }

    @Override
    public void saveAll(List<HumanEntity> list) {
        System.out.println(list);
    }

    public HumanEntity createEntity() {
        Date date;
        long ms;
        Random random = new Random();
        String[] randomStrings = new String[15];
        int id = random.nextInt(50);
        ms = -946771200000L + (Math.abs(random.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        date = new Date(ms);
        char[] word = new char[random.nextInt(8) + 3];
        for (int j = 0; j < word.length; j++) {
            word[j] = (char) ('a' + random.nextInt(26));
        }
        randomStrings[1] = new String(word);
        HumanEntity humanEntity = new HumanEntity((long) id, new String(word), date);
        return humanEntity;
    }
}

