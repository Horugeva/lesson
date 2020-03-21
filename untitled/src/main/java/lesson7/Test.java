package lesson7;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader myLoader = new MyLoader();
        myLoader.findClass("TestClass.class");
        myLoader.loadClass("TestClass.class");
    }
}
