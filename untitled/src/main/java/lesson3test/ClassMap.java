package lesson3test;

import java.util.*;

public class ClassMap {
    static Map<String, Integer> map = new HashMap<>();

    private static Map<String, Integer> createMap() {
        map.put("Иванов", 700);
        map.put("Петров", 700);
        map.put("Сидоров", 400);
        map.put("Степанов", 300);
        map.put("Васнецов", 800);
        map.put("Васильев", 700);
        map.put("Иванова", 100);
        map.put("Яковлев", 900);
        map.put("Петрова", 700);
        map.put("Сидорова", 200);
        return map;
    }

    public static void sortKeyMap() {
        TreeMap<String, Integer> sorted = new TreeMap<>(map);
        for (Map.Entry<String, Integer> entry : sorted.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    public static Map<String, Integer> sortValueMap() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());

            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        createMap();
        sortKeyMap();
        System.out.println("------------------------------------------");
        sortValueMap();
    }
}

