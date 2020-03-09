package lesson3;

import java.util.Objects;

public class Human {

    public String name;
    public int age;
    private Address address;

    public Human() {

    }


    public static class Address {

        private String city;
        private String street;
        private int home;
        private int flat;

        public Address(String city, String street, int home, int flat) {
            this.city = city;
            this.street = street;
            this.home = home;
            this.flat = flat;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getHome() {
            return home;
        }

        public void setHome(int home) {
            this.home = home;
        }

        public int getFlat() {
            return flat;
        }

        public void setFlat(int flat) {
            this.flat = flat;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "city='" + city + '\'' +
                    ", street='" + street + '\'' +
                    ", home=" + home +
                    ", flat=" + flat +
                    '}';
        }
    }

    public Human(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int setAge(int age) {
        this.age = age;
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name) &&
                Objects.equals(address, human.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}
