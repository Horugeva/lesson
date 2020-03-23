package lesson7.test;

public class Tester {
    private static final String DIRECTORYCLASS = "c:\\1\\";
    public static void main(String[] args) throws ClassNotFoundException {
        MyLoader myLoader = new MyLoader();
        myLoader.findClass(DIRECTORYCLASS);
        Class clazz = myLoader.loadClass("TestClass");
        Object obj = clazz.getName();
        System.out.println(obj);

    }
}

