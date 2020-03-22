package lesson7.test;

import lesson7.CustomClassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MyLoader extends CustomClassloader {
    @Override
    public Class findClass(String name) {
        byte[] b = loadClassFromFile("TestClass");
        return defineClass("TestClass", b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue;
        try {
            while ( (nextValue = inputStream.read()) != -1 ) {
                byteStream.write(nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no");
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}