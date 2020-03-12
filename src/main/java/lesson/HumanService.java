package lesson;

import lesson4.EntityCreationException;
import lesson4.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class HumanService implements Service<HumanDTO> {
    private Mapper<HumanEntity, HumanDTO> mapper = new MapperHuman();
    private Repository<HumanEntity> repository = new HumanRepository();
    private Logger logger = LoggerFactory.getLogger(HumanService.class);

    @Override
    public HumanDTO findUser(long id) throws EntityCreationException {

       HumanDTO humanDTO = new HumanDTO();
       try {
           HumanEntity humanEntity = repository.findUser(id);
           mapper.mapAToB(humanEntity, humanDTO);
       } catch (EntityCreationException | RepositoryException e) {
           logger.debug("Произошла ошибка при создании сущности", e);
       }
        return humanDTO;
    }

    @Override
    public List<HumanDTO> findAll() {
        List<HumanDTO> humanDTOList = new ArrayList<>();
        try {
            List<HumanEntity> humanEntityList = repository.findAll();
            for (HumanEntity humanEntity: humanEntityList){
                HumanDTO humanDTO = new HumanDTO();
                mapper.mapAToB(humanEntity, humanDTO);
                humanDTOList.add(humanDTO);
            }
        } catch (EntityCreationException | RepositoryException e){
            logger.debug("Произошла ошибка при создании списка", e);
        }
        return humanDTOList;
    }

    @Override
    public void save(HumanDTO humanDTO) {
        System.out.println(humanDTO);
        HumanEntity humanEntity = new HumanEntity();
        try {
            mapper.mapBToA(humanEntity, humanDTO);
            repository.save(humanEntity);
        }catch (EntityCreationException | RepositoryException e){
            logger.debug("Произошла ошибка при создании списка", e);
        }
    }

    @Override
    public void saveAll(List<HumanDTO> list) {
        System.out.println(list);
        List<HumanEntity> humanEntityList = new ArrayList<>();
        for (HumanDTO humanDTO: list){
            HumanEntity humanEntity = new HumanEntity();
            try {
            mapper.mapBToA(humanEntity, humanDTO);
                humanEntityList.add(humanEntity);
                repository.saveAll(humanEntityList);
            }catch (EntityCreationException | RepositoryException e) {
                logger.debug("Произошла ошибка при создании списка", e);
            }
        }
    }
}
