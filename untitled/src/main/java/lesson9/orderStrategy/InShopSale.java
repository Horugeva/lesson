package lesson9.orderStrategy;

public class InShopSale extends Order {
    public InShopSale() {

        this.payment = new Cash();
    }
}
