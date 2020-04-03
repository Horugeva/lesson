package lesson101;

import lesson101.annotation.Value;

public class HumanValue {
    @Value(name = "TestName", age = 15, filePath = "file")
    String name;
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

    public HumanValue(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public HumanValue() {

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
