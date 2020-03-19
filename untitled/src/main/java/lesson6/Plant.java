package lesson6;

import org.w3c.dom.Node;

public class Plant {
    String name, botanical, zone, light;
    int availability;
    String price;

    public Plant(String name) {

    }

    public void setName(String name) {
        this.name = name;
    }

    public Plant() {

    }

    public String getName() {
        return name;
    }


    public String getBotanical() {
        return botanical;
    }

    public String getLight() {
        return light;
    }

    public String getZone() {
        return zone;
    }

    public String getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }

    public Plant(String name, String botanical,  String zone, String light, String price, int availability) {
        this.name = name;
        this.botanical = botanical;
        this.light = light;
        this.zone = zone;
        this.price = price;
        this.availability = availability;
    }
}
