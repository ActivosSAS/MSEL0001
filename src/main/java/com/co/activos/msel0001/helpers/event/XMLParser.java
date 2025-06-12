package com.co.activos.msel0001.helpers.event;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;


public class XMLParser {
    public static String getIdEventoAsMap(String xml) {

        String idEventoValue = null;

        try {
            // Crear una fábrica para crear el parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el XML desde una cadena
            InputSource source = new InputSource(new StringReader(xml));

            // Obtener el documento XML
            Document document = builder.parse(source);

            // Obtener el nodo 'idEvento'
            Node idEventoNode = document.getElementsByTagName("idEvento").item(0);
            idEventoValue = idEventoNode.getTextContent();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return idEventoValue;
    }
}
