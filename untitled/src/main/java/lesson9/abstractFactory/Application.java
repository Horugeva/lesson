package lesson9.abstractFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    private OrderForm orderForm;

    public void drawOrderForm() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String orderName = reader.readLine();
        AbstractFactory abstractFactory;

        if (orderName.startsWith("sushi")) {
            abstractFactory = new SushiAbstractFactory();
        } else if (orderName.startsWith("burger")) {
            abstractFactory = new BurgerAbstractFactory();
        } else {
            System.out.println("Unknown order");
            return;
        }
        orderForm = new OrderForm(abstractFactory);
    }

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.drawOrderForm();
    }
}
