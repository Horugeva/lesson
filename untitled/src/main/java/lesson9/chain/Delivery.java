package lesson9.chain;

public class Delivery extends Handler {
    public Delivery() {
        super(SushiPrepare.Steps.DELIVERY);
    }

    @Override
    public void prepareImpl() {
        System.out.println("Отдаем клиенту готовый заказ");
    }
}
