package lesson2test;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

public class HumanEntity implements Serializable {
    private long id;
    private String name;
    private Date birthDate;
    private Address address;

    public HumanEntity(long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public HumanEntity() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public class Address {
        private String contry;
        private String city;
        private int index;

        public Address(String contry, String city, int index) {
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
        return (Data) birthDate;
    }

    public void setBirthDate(Data birthDate) {
        this.birthDate = (Date) birthDate;
    }

    @Override
    public String toString() {
        return "HumanEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}



