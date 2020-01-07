package com.pagisoft;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLGenerator {

    public void generateXMLFile(List<Club> clubsCollection) throws IOException {

        Element rootElement = new Element("element");
        Document doc = new Document();

        if (clubsCollection == null || clubsCollection.size() == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < clubsCollection.size(); i++) {
            Club club = clubsCollection.get(i);

            Element clubElement =new Element("club");
            clubElement.addContent(new Element("address").addContent(club.getAddress()));
            clubElement.addContent(new Element("email").addContent(club.getEmail()));
            clubElement.addContent(new Element("latitude").addContent(club.getLatitude()));
            clubElement.addContent(new Element("longitude").addContent(club.getLongitude()));
            clubElement.addContent(new Element("name").addContent(club.getName()));
            clubElement.addContent(new Element("phone").addContent(club.getPhone()));
            clubElement.addContent(new Element("city").addContent(club.getCity()));
            clubElement.addContent(new Element("category").addContent(club.getCategory()));

            rootElement.addContent(clubElement);
        }

        doc.setRootElement(rootElement);

        XMLOutputter outter = new XMLOutputter();
        outter.setFormat(Format.getPrettyFormat());
        outter.output(doc, new FileWriter(new File("myxml.xml")));
    }
}
