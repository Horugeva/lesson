package lesson;

import lesson4.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HumanRepository implements Repository<HumanEntity> {
    private Logger logger = LoggerFactory.getLogger(HumanRepository.class);

    @Override
    public HumanEntity findUser(long id) throws RepositoryException {
        try {
            createEntity();
    } catch (Exception e){
        logger.debug("Произошло исключение при создании сущности", e);
            throw new RepositoryException("RepositoryException");
    }
        return createEntity();
    }

    @Override
    public List<HumanEntity> findAll(){
        createEntity();
        List<HumanEntity> humanEntityList = new ArrayList<>();
        try {
            humanEntityList.add(createEntity());
        }catch (Exception e){
            logger.debug("Произошла ошибка создания списка", e);
            throw new RepositoryException("RepositoryException");
        }
        return humanEntityList;
    }

    @Override
    public void save(HumanEntity humanEntity) {
        System.out.println(humanEntity);
            logger.debug("Сохранении сущности");
    }

    @Override
    public void saveAll(List<HumanEntity> list) {
        System.out.println(list);
        logger.debug("Сохранении списка сущностей");
    }

    private HumanEntity createEntity() {
        Date date;
        long ms;
        Random random = new Random();
        int id = random.nextInt(50);
        ms = -946771200000L + (Math.abs(random.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        date = new Date(ms);
        char[] word = new char[random.nextInt(8) + 3];
        for (int j = 0; j < word.length; j++) {
            word[j] = (char) ('a' + random.nextInt(26));
        }
        return new HumanEntity(id, new String(word), date);
    }
}

