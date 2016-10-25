package com.selimcelik.domxml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyXml {

    public static void main(String[] args) {
        try {
            File file = new File("E:\\XmlTutorialsFiles/students.xml");
            DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=builderFactory.newDocumentBuilder();
            Document document=builder.parse(file);
            //First Element 
            Node studentNode=document.getElementsByTagName("student").item(0);
            System.out.println(studentNode);
            
            //add new Element
            Element year=document.createElement("year");
            year.appendChild(document.createTextNode("final year"));
            studentNode.appendChild(year);
            
            //update attribute            
            NamedNodeMap map=studentNode.getAttributes();
            Node attrNode=map.getNamedItem("id");
             attrNode.setTextContent("ECE");
             
             NodeList list=studentNode.getChildNodes();
             
             for (int i = 0; i < list.getLength(); i++) {
                Node node=list.item(i);
                
                 if ("lastname".equals(node.getNodeName())) {
                     node.setTextContent("aa");                     
                 }
                  if ("department".equals(node.getNodeName())) {
                     studentNode.removeChild(node);
                 }
            }
             TransformerFactory transformerFactory=TransformerFactory.newInstance();
             Transformer transformer=transformerFactory.newTransformer();
             DOMSource dOMSource=new DOMSource(document);
             StreamResult streamResult=new StreamResult(new File("E:\\XmlTutorialsFiles/students.xml"));
             transformer.transform(dOMSource, streamResult);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ModifyXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ModifyXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ModifyXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ModifyXml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ModifyXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
