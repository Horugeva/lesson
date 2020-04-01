package lesson101.src;


import lesson101.src.annotation.Entity;
import lesson101.src.annotation.Value;

@Entity
public class HumanEntity {

    @lesson10.annotation.Value(name = "TestName", filePath = "file.txt")
    String name;
    @Value(age = 15)
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HumanEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public HumanEntity() {

    }

    @Override
    public String toString() {
        return "HumanEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

