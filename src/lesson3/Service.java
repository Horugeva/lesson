package lesson3;
//Необходимо создать 10 объектов этого класса из которых 3 объекта должны быть дублями(не более одного дубля на каждого) и сделать с ними следующее:
//1. Заполнить ArrayList этими объектами.
//2. Найти дубли в коллекции и вывести их в консоль.
//3. Удалить дубли из коллекции, должно остаться 7 объектов.
//4. Отсортировать людей по ФИО
//5. Отсортировать людей по возрасту
//6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
import lesson3.comparator.HumanAddressComporator;
import lesson3.comparator.HumanAgeComporator;
import lesson3.comparator.HumanNameComporator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.valueOf;

public class Service {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main() {
        createCollection();
        //  System.out.println("Наш массив");
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


    public static List createCollection() {
        ArrayList<Human> list = new ArrayList<Human>();
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
        List list = createCollection();
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).toString().equals(list.get(j).toString())) {
                    list2.add(list.get(j).toString());
                    ;
                }
            }
        }
        for (int i = 0; i < list2.size(); i++)
            System.out.println(list2.get(i));
    }

    public static List removeDuplicates() {

        List list = createCollection();
        list = distinct(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }

    static void sortByName() {
        List list = createCollection();
        list = distinct(list);
        list.sort(new HumanNameComporator());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void sortByAge() {
        List list = createCollection();
         list = distinct(list);

        list.sort(new HumanAgeComporator());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void sortByAddress() {
        List list = createCollection();
        list = distinct(list);

        list.sort(new HumanAddressComporator());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    private static List<Human> distinct(List<Human> list){
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
}

