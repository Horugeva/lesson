package lesson3;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
//////11. Заполнить рандомными значениями LinkedList, вывести содержимое каждого элемента и его индекс.
public class LinkedL {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList();
        for (int i = 0; i < 10; i++){
            list.add(random.nextInt(50));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Индекс: " + list.indexOf(i) + ";    Элемент: " + list.get(i));
        }
    }
}
