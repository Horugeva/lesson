package lesson7.test;

public class Tester {
    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader myLoader = new MyLoader();
        myLoader.findClass("c:\\1\\");
        Class clazz = myLoader.loadClass("TestClass");
        Object obj = clazz.getName();
        System.out.println(obj);

    }
}

