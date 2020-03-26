package lesson2test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HumanRepository implements Repository<HumanEntity> {
   static Random random = new Random();
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

    private static HumanEntity createEntity() {
        int id = generateRandomId();
        Date birthDate = generateRandomBithDate();
        String nameEntity = generateRandomName();
        HumanEntity humanEntity = new HumanEntity(id, nameEntity, birthDate);
        return humanEntity;
    }

    private static int generateRandomId() {
        return random.nextInt(50);
    }

    private static Date generateRandomBithDate() {
        long ms = -946771200000L + (Math.abs(random.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        return new Date(ms);
    }

    private static String generateRandomName() {
        char[] nameEntity = new char[random.nextInt(8) + 3];
        for (int j = 0; j < nameEntity.length; j++) {
            nameEntity[j] = (char) ('a' + random.nextInt(26));
        }
        return new String(nameEntity);
    }

    public static void main(String[] args) {
        System.out.println(createEntity());
    }
}


