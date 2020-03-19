package lesson6;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateXMLFileDOMExample {
    private static final String FILENAME = "book.xml";

    public static void main(String[] args) {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element book = document.createElement("book");
            document.appendChild(book);
            Element autor = document.createElement("autor");
            book.appendChild(autor);
            Element firstName = document.createElement("firstname");
            firstName.setTextContent("Ивaнов");
            autor.appendChild(firstName);
            Element lastName = document.createElement("lastname");
            lastName.setTextContent("Ивaн");
            autor.appendChild(lastName);
            Element secondName = document.createElement("secondName");
            secondName.setTextContent("Иванович");
            autor.appendChild(secondName);
            Element title = document.createElement("title");
            title.setTextContent("Кулинария");
            book.appendChild(title);
            Element pages = document.createElement("pages");
            pages.setTextContent("100");
            book.appendChild(pages);
            Element publisher = document.createElement("publisher");
            publisher.setTextContent("МосИздат");
            book.appendChild(publisher);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(System.getProperty("user.dir") + File.separator + FILENAME));
            transformer.transform(source, result);
            System.out.println("Дokymeнт coхpaнeн!");
            } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(CreateXMLFileDOMExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
