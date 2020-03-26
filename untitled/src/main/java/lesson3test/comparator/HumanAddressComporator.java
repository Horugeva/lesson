package lesson3test.comparator;

import lesson3test.Human;

import java.util.Comparator;

public class HumanAddressComporator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAddress().toString().compareTo(o2.getAddress().toString());
    }
}
