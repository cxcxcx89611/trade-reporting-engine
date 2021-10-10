package com.au.vanguard.tradereportingengine.utils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class XMLParser {

    public static Document parseXMLStringIntoDocument(String xmlString) throws Exception {

        xmlString = xmlString.replaceAll("(<\\/?)[a-z0-9]+:","$1");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        //API to obtain DOM Document instance
        DocumentBuilder builder = null;

        builder = factory.newDocumentBuilder();

        //Parse the content to Document object
        Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

        return doc;
    }

}
