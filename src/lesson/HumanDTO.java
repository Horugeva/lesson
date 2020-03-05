package lesson;

import javax.xml.crypto.Data;
import java.io.Serializable;


public class HumanDTO implements Serializable {
    private long id;
    private String name;
    private Data birthDate;
    private AddressDTO addressDTO;

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public HumanDTO(long id, String name, Data birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    public HumanDTO() {
    }

    public class AddressDTO {
        private String contry;
        private String city;
        private int index;

        public AddressDTO(String contry, String city, int index) {
            this.contry = contry;
            this.city = city;
            this.index = index;
        }

        public String getContry() {
            return contry;
        }

        public void setContry(String contry) {
            this.contry = contry;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Data birthDate) {
        this.birthDate = birthDate;
    }


}
