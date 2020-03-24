package lesson6;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXPlant {

    private static ArrayList<Plant> plants = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        AdvancedXMLHandler handler = new AdvancedXMLHandler();
        parser.parse(new File("file.xml"), handler);
        for (Plant plant : plants)
            System.out.println(String.format("Название растения: %s %s %s %s %s %s", plant.getName(),
                    plant.getBotanical(), plant.getZone(), plant.getLight(), plant.getPrice(), plant.getAvailability()));

    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String name, botanical, zone, light, lastElementName;
        private int availability;
        private String price;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if (!information.isEmpty()) {
                if (lastElementName.equals("COMMON"))
                    name = information;
                if (lastElementName.equals("BOTANICAL"))
                    botanical = information;
                if (lastElementName.equals("ZONE"))
                    zone = information;
                if (lastElementName.equals("LIGHT"))
                    light = information;
                if (lastElementName.equals("PRICE"))
                    price = information;
                if (lastElementName.equals("AVAILABILITY"))
                    availability = new Integer(information);
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ((name != null && !name.isEmpty()) && (botanical != null && !botanical.isEmpty() &&
                    (zone != null && !zone.isEmpty()) && (light != null && !light.isEmpty()) &&
                    (price != null && !price.isEmpty()) && (availability != 0))) {

                plants.add(new Plant(name, botanical, zone, light, price, availability));
                name = null;
                botanical = null;
                zone = null;
                light = null;
                price = null;
                availability = 0;
            }
        }
    }
}


