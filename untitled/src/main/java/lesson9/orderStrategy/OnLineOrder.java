package lesson9.orderStrategy;

public class OnLineOrder extends Order {
    public OnLineOrder() {

        this.payment = new OnLine();
    }
}

