package lesson3test;

import lesson3test.comparator.HumanAddressComporator;
import lesson3test.comparator.HumanAgeComporator;
import lesson3test.comparator.HumanNameComporator;

import java.util.*;

public class Service {

    public static void main(String[] args) {
        createCollection();
        System.out.println("--------------------------------------------------------------------------------------------");
        printDuplicates();
        System.out.println("Дублирующие строки");
        System.out.println("--------------------------------------------------------------------------------------------");
        removeDuplicates();
        System.out.println("Без дублирующих строк");
        System.out.println("--------------------------------------------------------------------------------------------");
        sortByName();
        System.out.println("Сортировка по имени");
        System.out.println("--------------------------------------------------------------------------------------------");
        sortByAge();
        System.out.println("Сортировка по возрасту");
        System.out.println("--------------------------------------------------------------------------------------------");
        sortByAddress();
        System.out.println("Сортировка по адресу");
    }

    public static List<Human> createCollection() {
        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human("Fedya", 15, new Human.Address("Kiev", "Lenina", 15, 25)));
        list.add(new Human("Masha", 18, new Human.Address("Moskow", "Lenona", 25, 15)));
        list.add(new Human("Petrovich", 55, new Human.Address("Ryzan", "Voroshilova", 71, 69)));
        list.add(new Human("Petrovich", 55, new Human.Address("Ryzan", "Voroshilova", 71, 69)));
        list.add(new Human("Ivanov", 32, new Human.Address("Pskov", "Artema", 172, 61)));
        list.add(new Human("Zorin", 55, new Human.Address("Minsk", "Centr", 72, 123)));
        list.add(new Human("Zorin", 55, new Human.Address("Minsk", "Centr", 72, 123)));
        list.add(new Human("Koshkina", 36, new Human.Address("Tver", "Centr2", 2, 23)));
        list.add(new Human("Zorina", 50, new Human.Address("Omsk", "Pobedy", 64, 85)));
        list.add(new Human("Fedya", 15, new Human.Address("Kiev", "Lenina", 15, 25)));
        return list;
    }

    static void printDuplicates() {
        List<Human> list = createCollection();
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).toString().equals(list.get(j).toString())) {
                    list2.add(list.get(j).toString());
                }
            }
        }
        for (String s : list2) System.out.println(s);
    }

    static void removeDuplicates() {
        List<Human> list = createCollection();
        distinct(list);
        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void sortByName() {
        List<Human> list = createCollection();
        distinct(list);
        list.sort(new HumanNameComporator());
        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void sortByAge() {
        List<Human> list = createCollection();
        distinct(list);

        list.sort(new HumanAgeComporator());

        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void sortByAddress() {
        List<Human> list = createCollection();
        distinct(list);

        list.sort(new HumanAddressComporator());

        for (Human human : list) {
            System.out.println(human);
        }
    }

    private static List<Human> distinct(List<Human> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).toString().equals(list.get(j).toString())) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
