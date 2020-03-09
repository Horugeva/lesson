package lesson3.comparator;

import lesson3.Human;

import java.util.Comparator;
import java.util.List;

public class HumanAgeComporator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
