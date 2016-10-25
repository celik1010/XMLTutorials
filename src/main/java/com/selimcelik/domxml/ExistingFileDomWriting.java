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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ExistingFileDomWriting {

    public static void main(String[] args) {
        try {
            
            //Dosyayı hafızaya almak için
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File("E:\\XmlTutorialsFiles/ogrenciler.xml"));
            
            //ogrenci elementi oluşturuyor
            Element ogrenci = document.createElement("ogrenci");

            //öğrenciye no özelliği eklenmesi ve değer atanması
            Attr no = document.createAttribute("no");
            no.setValue("1");
            ogrenci.getAttributes().setNamedItem(no);

            //ad ve soyad elementlerin oluşturulması ve değer atanması
            Element ad = document.createElement("ad");
            ad.setTextContent("Deniz");
            Element soyad = document.createElement("soyad");
            soyad.setTextContent("Çelik");

            //ad ve soyad elementlerini ogrenci elementine eklenmesi
            ogrenci.appendChild(ad);
            ogrenci.appendChild(soyad);

            //ogrenci elementinin dökümana eklenmesi
            document.getDocumentElement().appendChild(ogrenci);

            //Diske yazmak için dönüştürücü oluşturulur
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //yazılacak kaynak oluşturulur
            StreamResult result = new StreamResult(new File("E:\\XmlTutorialsFiles/ogrenciler.xml"));
            //okunacak kaynak oluşturulur
            DOMSource source = new DOMSource(document);
            //okunacak kaynakdan dokümanı okur, yazılacak kaynağa yazar..
            transformer.transform(source, result);
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ExistingFileDomWriting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ExistingFileDomWriting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExistingFileDomWriting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ExistingFileDomWriting.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ExistingFileDomWriting.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
