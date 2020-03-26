package lesson6;
import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

public class DocbookXSDCheck {

    public static void main(String[] args) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("book.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("book.xml")));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        }
    }
}

