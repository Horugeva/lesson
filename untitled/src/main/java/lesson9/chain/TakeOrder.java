package lesson9.chain;

public class TakeOrder extends Handler {
    public TakeOrder() {
        super(SushiPrepare.Steps.TAKEORDER);
    }

    @Override
    public void prepareImpl() {
        System.out.println("Принимаем заказ");

    }
}
