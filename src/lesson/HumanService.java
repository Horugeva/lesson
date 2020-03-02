package lesson;

import java.util.ArrayList;
import java.util.List;

public class HumanService implements Service<HumanDTO> {
    private Mapper<HumanEntity, HumanDTO> mapper = new MapperHuman();
    private Repository<HumanEntity> repository = new HumanRepository();

    @Override
    public HumanDTO findUser(long id) {
        HumanEntity humanEntity = repository.findUser(id);
       HumanDTO humanDTO = new HumanDTO();
       mapper.mapAToB(humanEntity, humanDTO);
       return humanDTO;
    }

    @Override
    public List<HumanDTO> findAll() {
       List<HumanDTO> humanDTOList = new ArrayList<>();
       List<HumanEntity> humanEntityList = repository.findAll();
        for (HumanEntity humanEntity: humanEntityList){
           HumanDTO humanDTO = new HumanDTO();
            mapper.mapAToB(humanEntity, humanDTO);
            humanDTOList.add(humanDTO);
        }
       return humanDTOList;
    }

    @Override
    public void save(HumanDTO humanDTO) {
        System.out.println(humanDTO);
        HumanEntity humanEntity = new HumanEntity();
        mapper.mapBToA(humanEntity, humanDTO);
        repository.save(humanEntity);
    }

    @Override
    public void saveAll(List<HumanDTO> list) {
        System.out.println(list);
        List<HumanEntity> humanEntityList = new ArrayList<>();
        for (HumanDTO humanDTO: list){
            HumanEntity humanEntity = new HumanEntity();
            mapper.mapBToA(humanEntity, humanDTO);
            humanEntityList.add(humanEntity);
        }
        repository.saveAll(humanEntityList);
    }
}
