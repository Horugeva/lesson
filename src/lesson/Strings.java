package lesson;

public class Strings {
    public static void main(String[] args) {
        String string = "Мама мыла раму";
        String string2 = "МАМА МЫЛА РАМУ";
        System.out.println(string.length());
        System.out.println(string.equalsIgnoreCase(string2));
        String string3 = new String("Просто строка");
        String string4 = string3.intern();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++)
            System.out.print(chars[i] + " ");
        System.out.println();
        byte[] bytes = string.getBytes();
        for (int i = 0; i < string.length(); i++)
            System.out.print(bytes[i] + " ");
        System.out.println();
        System.out.println(string.toUpperCase());
        System.out.println(string.indexOf("а"));
        System.out.println(string.lastIndexOf("а"));
        if (string.contains("мыла")) {
            System.out.println("Содержит");
        } else System.out.println("Не содержит");
        boolean retVal;
        retVal = string.endsWith("Oracle");
        System.out.println(retVal);
        retVal = string.startsWith("Java");
        System.out.println(retVal);
        System.out.println(string.replace('а', 'о'));
        System.out.println(string.substring(5, 12));
        String[] words = string.split(" ");
        for (int i = 0; i < words.length; i++)
            System.out.println(words[i]);
        StringBuffer buffer = new StringBuffer("Мама мыла раму");
        buffer.reverse();
        System.out.println(buffer);

    }

}
