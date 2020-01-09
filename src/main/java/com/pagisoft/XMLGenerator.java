package com.pagisoft;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class XMLGenerator {

    public void generateXMLFile(List<Club> clubsCollection, String outputFilePath) throws IOException {

        Element rootElement = new Element("element");
        Document doc = new Document();

        if (clubsCollection == null || clubsCollection.size() == 0) {
            throw new IllegalArgumentException();
        }

        for (Iterator<Club> iterator = clubsCollection.iterator(); iterator.hasNext(); ) {

            Club club = iterator.next();

            Element clubElement =new Element("club");
            clubElement.addContent(new Element("address").addContent(club.getAddress()));
            clubElement.addContent(new Element("email").addContent(club.getEmail()));
            clubElement.addContent(new Element("name").addContent(club.getName()));
            clubElement.addContent(new Element("phone").addContent(club.getPhone()));
            clubElement.addContent(new Element("website").addContent(club.getWebsite()));
            clubElement.addContent(new Element("city").addContent(club.getCity()));
            clubElement.addContent(new Element("category").addContent(club.getCategory()));
            clubElement.addContent(new Element("placeId").addContent(club.getPlaceId()));

            rootElement.addContent(clubElement);
        }

        doc.setRootElement(rootElement);

        XMLOutputter outputter = new XMLOutputter();
        outputter.setFormat(Format.getPrettyFormat());
        outputter.output(doc, new FileWriter(new File(outputFilePath)));
    }
}
