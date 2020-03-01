package lesson;

public class MapperHuman implements Mapper<HumanEntity, HumanDTO>{

    private void AddressEntityMapper(HumanEntity.Address addressEntity, HumanDTO.Address addressDTO) {
        addressEntity.setContry(addressDTO.getContry());
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setIndex(addressDTO.getIndex());
    }

    private void AddressDTOMapper(HumanEntity.Address addressEntity, HumanDTO.Address addressDTO) {
        addressDTO.setContry(addressEntity.getContry());
        addressDTO.setCity(addressEntity.getCity());
        addressDTO.setIndex(addressEntity.getIndex());
    }

    @Override
    public void mapAToB(HumanEntity humanEntity, HumanDTO humanDTO) {
        humanEntity.setName(humanDTO.getName());
        humanEntity.setId(humanDTO.getId());
        humanEntity.setBirthDate(humanDTO.getBirthDate());
        AddressEntityMapper(humanEntity.getAddress(), humanDTO.getAddress());
    }

    @Override
    public void mapBToA(HumanEntity humanEntity, HumanDTO humanDTO) {
        humanDTO.setName(humanEntity.getName());
        humanDTO.setId(humanEntity.getId());
        humanDTO.setBirthDate(humanEntity.getBirthDate());
        AddressDTOMapper(humanEntity.getAddress(), humanDTO.getAddress());
    }
}
