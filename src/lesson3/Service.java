package lesson3;
//Необходимо создать 10 объектов этого класса из которых 3 объекта должны быть дублями(не более одного дубля на каждого) и сделать с ними следующее:
//1. Заполнить ArrayList этими объектами.
//2. Найти дубли в коллекции и вывести их в консоль.
//3. Удалить дубли из коллекции, должно остаться 7 объектов.
//4. Отсортировать людей по ФИО
//5. Отсортировать людей по возрасту
//6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
import java.util.*;

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

    public static void main(String[] args) {
        sozdanie();
        //  System.out.println("Наш массив");
        System.out.println("--------------------------------------------------------------------------------------------");
        vivodDubley();
        System.out.println("Дублирующие строки");
        System.out.println("--------------------------------------------------------------------------------------------");
        udalenieDubley();
        System.out.println("Без дублирующих строк");
        System.out.println("--------------------------------------------------------------------------------------------");
        sortName();
        System.out.println("Сортировка по имени");
        System.out.println("--------------------------------------------------------------------------------------------");
        sortAge();
        System.out.println("Сортировка по возрасту");
        System.out.println("--------------------------------------------------------------------------------------------");
        sortAddress();
        System.out.println("Сортировка по адресу");
        System.out.println("--------------------------------------------------------------------------------------------");
    }


    public static List sozdanie() {
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

    private static void vivodDubley() {
        List list = sozdanie();
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

    public static List udalenieDubley() {
        List list = sozdanie();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).toString().equals(list.get(j).toString())) {
                    list.remove(j);
                    j--;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return list;
    }

    public static List ubranyDubley() {
        List list = sozdanie();
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

    private static void sortName() {
        List list = ubranyDubley();

        list.sort(new Comparator<Human>() {
                      @Override
                      public int compare(Human o1, Human o2) {
                          return o1.name.compareTo(o2.name);
                      }
                  }
        );
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void sortAge() {
        List list = ubranyDubley();

        list.sort(new Comparator<Human>() {
                      @Override
                      public int compare(Human o1, Human o2) {
                          return Integer.valueOf(o1.age).compareTo(o2.age);
                      }
                  }
        );

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    private static void sortAddress() {
        List list = ubranyDubley();

        list.sort(new Comparator<Human>() {
                      @Override
                      public int compare(Human o1, Human o2) {
                          return o1.getAddress().toString().compareTo(o2.getAddress().toString());
                      }
                  }
        );
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

