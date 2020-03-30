package lesson9.chain;

public class Prepare extends Handler {
    public Prepare() {
        super(SushiPrepare.Steps.PREPARE);
    }

    @Override
    public void prepareImpl() {
        System.out.println("Готовим заказ");

    }
}
