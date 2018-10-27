package cn.xyh.testjpa.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
//        test();
    }

    public static void test() throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {
        File file = new File("C:\\work\\test-jpa\\src\\main\\resources\\a.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse(file);

//        Element ele = document.getDocumentElement();

        Element root = document.createElement("Root");

        document.appendChild(root);

        DOMSource source = new DOMSource(document);


        StreamResult sr = new StreamResult(file);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//        t.transform(src, sr);



    }
}
