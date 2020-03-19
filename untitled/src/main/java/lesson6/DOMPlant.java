package lesson6;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
            System.out.print(plant.getTextContent());

        }
    }
}
