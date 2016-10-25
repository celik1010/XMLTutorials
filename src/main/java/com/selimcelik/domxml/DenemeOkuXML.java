package com.selimcelik.domxml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DenemeOkuXML {

    public static void main(String[] args) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File("E:\\XmlTutorialsFiles/ogrenciler.xml"));

            document.getDocumentElement().getNodeName();
            System.out.println(document.getDocumentElement().getNodeName());

            NodeList list = document.getElementsByTagName("ogrenci");
            for (int i = 0; i < list.getLength(); i++) {
                Node ogrenciNode = list.item(i);
                NamedNodeMap attrMap = ogrenciNode.getAttributes();
                attrMap.getNamedItem("no");
                System.out.println("NO : " + attrMap.getNamedItem("no").getNodeValue());

                if (ogrenciNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) ogrenciNode;
                    System.out.println(element.getElementsByTagName("ad").item(0).getTextContent());
                }

//                // Öğrenci elementinin bütün elemanlarını getirir
//                NodeList list1 = ogrenciNode.getChildNodes();
//                for (int j = 0; j < list1.getLength(); j++) {
//                    Node node1 = list1.item(j);
//                    if (node1.getNodeType() != Node.TEXT_NODE) {
//                        System.out.println(node1.getNodeName() + ":" + node1.getTextContent());
//                    }
//                }
                System.out.println("---------------------------");
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DenemeOkuXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DenemeOkuXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DenemeOkuXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
