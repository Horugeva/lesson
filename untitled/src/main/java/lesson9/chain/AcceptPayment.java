package lesson9.chain;

public class AcceptPayment extends Handler {
    public AcceptPayment() {
        super(SushiPrepare.Steps.ACCEPTPAYMENT);
    }

    @Override
    public void prepareImpl() {
        System.out.println("Принимаем оплату");
    }
}
