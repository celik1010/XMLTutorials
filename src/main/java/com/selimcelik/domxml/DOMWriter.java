package com.selimcelik.domxml;

import java.io.ByteArrayInputStream;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DOMWriter {

    public static void main(String[] args) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            stringBuilder.append("<ogrenciler></ogrenciler>");

            Document document = builder.parse(new ByteArrayInputStream(stringBuilder.toString().getBytes()));

            Element ogrenci = document.createElement("ogrenci");

            Attr no = document.createAttribute("no");
            no.setValue("0");
            ogrenci.getAttributes().setNamedItem(no);

            Element ad = document.createElement("ad");
            ad.setTextContent("Selim");

            Element soyad = document.createElement("soyad");
            soyad.setTextContent("Çelik");

            ogrenci.appendChild(ad);
            ogrenci.appendChild(soyad);

            document.getDocumentElement().appendChild(ogrenci);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            StreamResult result = new StreamResult(new File("E:\\XmlTutorialsFiles/ogrenciler.xml"));

            DOMSource source = new DOMSource(document);

            transformer.transform(source, result);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DOMWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DOMWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DOMWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DOMWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
