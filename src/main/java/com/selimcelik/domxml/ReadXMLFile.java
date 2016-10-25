package com.selimcelik.domxml;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFile {

    public static void main(String[] args) {
        try {
            File file = new File("E:\\XmlTutorialsFiles/students.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            System.out.println(document.getDocumentElement().getNodeName());

            NodeList list = document.getElementsByTagName("student");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                System.out.println("**************");
                System.out.println("Child Element :" + node.getNodeName());

                if (node.getNodeType() == node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println(element.getAttribute("id"));
                    System.out.println(element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.err.println(element.getElementsByTagName("lastname").item(0).getTextContent());
//                    System.out.println(element.getElementsByTagName("department").item(0).getTextContent());
                }

            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReadXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ReadXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
