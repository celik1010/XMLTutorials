package com.selimcelik.domxml;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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

public class ReadFromTCMB {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.tcmb.gov.tr/kurlar/today.xml");
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(url.openStream());

            System.out.println(document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("Currency");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    
                    if (element.getElementsByTagName("Isim").item(0).getTextContent().equals("ABD DOLARI")) {
                        System.out.println("ABD DOLARI");
                        System.out.println("Döviz Cinsi : " + element.getElementsByTagName("Isim").item(0).getTextContent());
                        System.out.println("Döviz Adı : " + element.getElementsByTagName("CurrencyName").item(0).getTextContent());
                        System.out.println("Döviz Alış : " + element.getElementsByTagName("ForexBuying").item(0).getTextContent());
                        System.out.println("Döviz Satış : " + element.getElementsByTagName("ForexSelling").item(0).getTextContent());
                        System.out.println("Efektif Alış : " + element.getElementsByTagName("BanknoteBuying").item(0).getTextContent());
                        System.out.println("Efektif Satış : " + element.getElementsByTagName("BanknoteSelling").item(0).getTextContent());
                    }                    

                }
                System.out.println("#####################################3");
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(ReadFromTCMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReadFromTCMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ReadFromTCMB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadFromTCMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
