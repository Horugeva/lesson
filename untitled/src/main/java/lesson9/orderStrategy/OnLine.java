package lesson9.orderStrategy;

public class OnLine implements Payment {

    @Override
    public void payment() {
        System.out.println("Сбербанк Онлайн");
    }
}
