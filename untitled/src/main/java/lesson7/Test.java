package lesson7;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {
    private static final String PATHNAME = "c:\\1\\";

    public static void main(String[] args) {
        File file = new File(PATHNAME);
        try {
            URL url = file.toURI().toURL();
            URL[] urls = new URL[]{url};
            ClassLoader classLoader = new URLClassLoader(urls);
            Class classT = classLoader.loadClass("TestClass");
            System.out.println(classT.toString());
            System.out.println(classT.getClass());
        } catch (MalformedURLException e) {
            System.out.println("File upload exception");
        } catch (ClassNotFoundException e) {
            System.out.println("File upload exceptiono");
        }
    }
}