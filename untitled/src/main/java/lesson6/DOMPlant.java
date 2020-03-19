package lesson6;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMPlant {
    private static ArrayList<Plant> plants = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("file.xml"));
        NodeList plantElements = document.getDocumentElement().getElementsByTagName("PLANT");

        for (int i = 0; i < plantElements.getLength(); i++) {
            Node plant = plantElements.item(i);
           // System.out.println(plant.getTextContent().replace("\n", "").replace("        ", " ").trim());
            System.out.print(plant.getTextContent());

                    /*    NamedNodeMap attributes = plant.getAttributes();

            plants.add(new Plant(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("botanical").getNodeValue(), attributes.getNamedItem("zona").getNodeValue(),
                    attributes.getNamedItem("light").getNodeValue(), attributes.getNamedItem("price").getNodeValue(), new Integer(attributes.getNamedItem("availability").getNodeValue())));
        }

        for (Plant plant : plants)
            System.out.println(String.format("Название растения: %s %s %s %s %s %s", plant.getName(), plant.getBotanical(), plant.getZone(),
                    plant.getLight(), plant.getPrice(), plant.getAvailability()));
  */
        }
    }
}
