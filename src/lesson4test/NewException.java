package lesson4test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewException {
    public static void main(String[] args) {
        try {
            action();
        } catch (ArithmeticException e) {
            System.out.println("На 0 делить нельзя!");

        } catch (IOException e) {
            System.out.println("Любые ошибки");
        }
    }

    public static void action() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        System.out.println(x / y);
    }
}

