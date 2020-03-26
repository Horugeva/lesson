package lesson3test;

import java.util.EnumMap;
import java.util.Map;

public class Users {
    public String name;
    public String functions;

    public Users(String name, String functions) {
        this.name = name;
        this.functions = functions;
    }

    public static EnumMap<Role, Users> createUsers() {
        EnumMap<Role, Users> map = new EnumMap<>(Role.class);
        map.put(Role.ADMIN, new Users("Петя", "Выполняет обязанности админа"));
        map.put(Role.MODERATOR, new Users("Вася", "Выполняет обязанности модератора"));
        map.put(Role.USER, new Users("Маша", "Выполняет обязанности пользователя"));
        return map;
    }

    public static void main(String[] args) {
        Map<Role, Users> map = createUsers();
        printPeopleList(map);
    }

    @Override
    public String toString() {
        return name + ' ' +
                functions;
    }

    public static void printPeopleList(Map<Role, Users> map) {
        for (Map.Entry<Role, Users> s : map.entrySet()) {
            System.out.println("Приветствуем " + s.getKey() + " " + s.getValue());
        }
    }
}

