package lesson3;
////7. Создать класс User добавить в него поля ФИО, и роль которое является перечислением и содержит в себе ADMIN, USER, MODERATOR
////8. Необходимо написать метод в который входным значением будет являтся объект класса User, метод должен на основании роли пользователя выводить приветственное сообщение,
//// что-то вроде "Приветствуем ФИО с ролью " + ОПИСАНИЕ_РОЛИ
////описание роли должно вычисляться на основании роли пользователя, запрещено использовать if и switch, а так же описание роли в перечислении.
//public class User{
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Users {
    public String name;
    public String opisanie;
    public Role role;
    EnumMap<Role, Users> activityMap;

    public Users(String name, String opisanie) {
        this.name = name;
        this.opisanie = opisanie;
    }

    public Users(EnumMap<Role, Users> activityMap) {
        this.activityMap = activityMap;
    }

    public static Map sozdanie(){
     EnumMap<Role, Users> map = new EnumMap<Role, Users>(Role.class);
     map.put(Role.ADMIN, new Users("Петя", "Выполняет обязанности админа" ));
     map.put(Role.MODERATOR, new Users("Вася", "Выполняет обязанности модератора" ));
     map.put(Role.USER, new Users("Маша", "Выполняет обязанности пользователя" ));
     for (Map.Entry<Role, Users> s : map.entrySet()){

     }
     return map;
}

    public static void main() {
        Map<Role, Users> map = sozdanie();

        printPeopleList(map);
        }

    @Override
    public String toString() {
        return name + ' ' +
                 opisanie;
    }

    public static void printPeopleList(Map<Role, Users> map) {
        for (Map.Entry<Role, Users> s : map.entrySet()) {
            System.out.println("Приветствуем " + s.getKey() + " " + s.getValue());
        }

    }
}

