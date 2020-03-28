package lesson9.orderStrategy;

public class Cash implements Payment {

    @Override
    public void payment() {
        System.out.println("Оплата наличными");
    }
}
