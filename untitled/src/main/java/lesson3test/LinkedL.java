package lesson3test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedL {
    public static List<Integer> createRandomList() {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(50));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = createRandomList();
        for (int i = 0; i < 10; i++) {
            System.out.println("Индекс: " + list.indexOf(i) + ";    Элемент: " + list.get(i));
        }
    }
}
