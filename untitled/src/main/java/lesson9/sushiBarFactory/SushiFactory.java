package lesson9.sushiBarFactory;

public class SushiFactory {
    public Sushi createSushi(SushiType type) {
        Sushi sushi = null;
        switch (type) {
            case MAKI:
                sushi = new Maki();
                break;
            case NIGIRI:
                sushi = new Nigiri();
                break;
            case SASHIMI:
                sushi = new Sashimi();
                break;
        }
        return sushi;
    }
}
