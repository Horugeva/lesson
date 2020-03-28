package lesson9.sushiBarFactory;

public class SushiShop {
    private final SushiShop sushiShop;

    public SushiShop(SushiShop sushiShop) {
        this.sushiShop = sushiShop;
    }

    public Sushi orderSushi(SushiType type) {
        Sushi sushi = new Sushi();
        sushi.takeOnOrder();
        sushi.prepare();
        sushi.toRealize();
        return sushi;
    }
}
