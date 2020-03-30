package lesson9.orderStrategy;

public class MailOrder extends Order {
    public MailOrder() {

        this.payment = new Card();
    }
}

