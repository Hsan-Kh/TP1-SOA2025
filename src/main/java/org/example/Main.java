package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String xmlPath = "src/main/resources/farm.xml";
        String xsdPath = "src/main/resources/farm.xsd";

        try {
            System.out.println(" Validation du fichier XML :");
            if (validateXML(xmlPath, xsdPath)) {
                System.out.println("\n XML valide selon le schéma XSD ");
            } else {
                System.out.println("\n XML invalide selon le schéma XSD ");
                return;
            }
            System.out.println("\n Requêtes XPath :");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlPath));
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            printQuery(xpath, doc, "//culture[@type='bio']/@nom", "Cultures bio");
            printQuery(xpath, doc, "//champ[number(@humidite) < 50]/@id", "Champs avec humidité < 50%");
            printQuery(xpath, doc, "//employe[@actif='true']/@prenom", "Employés actifs");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Implémentation de la validation XML/XSD
    private static boolean validateXML(String xmlPath, String xsdPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            return true;
        } catch (Exception e) {
            System.err.println("Erreur de validation : " + e.getMessage());
            return false;
        }
    }

//Interrogation XPath
    private static void printQuery(XPath xpath, Document doc, String expression, String titre) throws Exception {
        XPathExpression expr = xpath.compile(expression);
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        System.out.println("\n" + titre + " :");
        if (nodes.getLength() == 0) {
            System.out.println("   Aucun résultat.");
        } else {
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("   - " + nodes.item(i).getNodeValue());
            }
        }
    }
}
