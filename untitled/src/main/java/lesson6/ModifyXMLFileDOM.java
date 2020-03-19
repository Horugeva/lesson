package lesson6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ModifyXMLFileDOM {

    public static void main(String[] args) {
         File xmlFile = new File("file.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
             updateElementValue(doc);
               addElement(doc);
             doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("fileMod.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML успешно изменен!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    private static void addElement(Document doc) {
        NodeList plants = doc.getElementsByTagName("Plant");
        Element plant;
         for(int i=0; i<plants.getLength(); i++){
            plant = (Element) plants.item(i);
            Element contryElement = doc.createElement("contry");
            contryElement.appendChild(doc.createTextNode("Russia"));
            plant.appendChild(contryElement);
        }
    }

     private static void updateElementValue(Document doc) {
        NodeList plants = doc.getElementsByTagName("Plant");
        Element plant;
          for(int i=0; i<plants.getLength();i++){
            plant = (Element) plants.item(i);
            Node name = plant.getElementsByTagName("COMMON").item(1).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }
    }
}