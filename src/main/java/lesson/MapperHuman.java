
package lesson;

import lesson4.EntityCreationException;
import lesson4.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperHuman implements Mapper<HumanEntity, HumanDTO>{
    private Logger logger = LoggerFactory.getLogger(MapperHuman.class);

    private void AddressEntityMapper(HumanEntity.Address addressEntity, HumanDTO.AddressDTO addressDTO) {
        try {
            addressEntity.setContry(addressDTO.getContry());
            addressEntity.setCity(addressDTO.getCity());
            addressEntity.setIndex(addressDTO.getIndex());
        }catch (Exception e){
            logger.debug("Произошло исключение при конвертации адреса сущности", e);
            throw new EntityCreationException("EntityCreationException");
        }
    }

    private void AddressDTOMapper(HumanEntity.Address addressEntity, HumanDTO.AddressDTO addressDTO) {
        try {
            addressDTO.setContry(addressEntity.getContry());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setIndex(addressEntity.getIndex());
        }catch (Exception e){
            logger.debug("Произошло исключение при конвертации адреса сущности", e);
            throw new EntityCreationException("EntityCreationException");
        }
    }

    @Override
    public void mapAToB(HumanEntity humanEntity, HumanDTO humanDTO) {
        try {
        humanEntity.setName(humanDTO.getName());
        humanEntity.setId(humanDTO.getId());
        humanEntity.setBirthDate(humanDTO.getBirthDate());
        AddressEntityMapper(humanEntity.getAddress(), humanDTO.getAddressDTO());
        }catch (Exception e){
            logger.debug("Произошло исключение при конвертации сущности", e);
            throw new EntityCreationException("EntityCreationException");
        }
    }

    @Override
    public void mapBToA(HumanEntity humanEntity, HumanDTO humanDTO) {
        try {
        humanDTO.setName(humanEntity.getName());
        humanDTO.setId(humanEntity.getId());
        humanDTO.setBirthDate(humanEntity.getBirthDate());
        AddressDTOMapper(humanEntity.getAddress(), humanDTO.getAddressDTO());
        }catch (Exception e){
            logger.debug("Произошло исключение при конвертации сущности", e);
            throw new EntityCreationException("EntityCreationException");
        }
    }
}
