package lesson4test.human;

import lesson4test.RepositoryException;
import lesson4test.EntityCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HumanRepository implements Repository<HumanEntity> {
    private Logger logger = LoggerFactory.getLogger(HumanRepository.class);
    static Random random = new Random();

    public HumanEntity findUser(long id) throws RepositoryException {
        try {
            return createEntity();
        } catch (EntityCreationException e) {
            logger.debug("An exception occurred when creating an entity", e);
            throw new RepositoryException("RepositoryException");
        }
    }

    @Override
    public List<HumanEntity> findAll(){
        createEntity();
        List<HumanEntity> humanEntityList = new ArrayList<>();
        try {
            humanEntityList.add(createEntity());
            return humanEntityList;
        }catch (EntityCreationException e){
            logger.debug("An error occurred creating the list", e);
            throw new RepositoryException("RepositoryException");
        }
    }

    @Override
    public void save(HumanEntity humanEntity) {
        System.out.println(humanEntity);
        logger.debug("Saving an entity");
    }

    @Override
    public void saveAll(List<HumanEntity> list) {
        System.out.println(list);
        logger.debug("Saving a list of entities");
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

}


