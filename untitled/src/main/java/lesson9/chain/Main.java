package lesson9.chain;

public class Main {
    public static void main(String[] args) {
        Handler firstHandler, lastHandler;
        firstHandler = lastHandler = new TakeOrder();
        lastHandler = lastHandler.setNext(new Prepare()).setNext(new Delivery()).setNext(new AcceptPayment());
        SushiPrepare sp = new SushiPrepare(
                SushiPrepare.Steps.TAKEORDER,
                SushiPrepare.Steps.PREPARE,
                SushiPrepare.Steps.DELIVERY,
                SushiPrepare.Steps.ACCEPTPAYMENT);
    }
}
