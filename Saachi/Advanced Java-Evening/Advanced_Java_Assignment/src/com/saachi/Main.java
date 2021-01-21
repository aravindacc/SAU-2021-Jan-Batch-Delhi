package com.saachi;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.format.DateTimeFormatter;

import static com.saachi.License.*;
import static com.saachi.MergedList.mergeXMLFiles;

public class Main {

    public static void writeToXMLFile(Document XMLDoc, String OutputFileName){
        try {
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(XMLDoc);
                StreamResult result = new StreamResult(new StringWriter());
                transformer.transform(source, result);

                Writer output = new BufferedWriter(new FileWriter(OutputFileName));
                String xmlOutput = result.getWriter().toString();
                output.write(xmlOutput);
                output.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String XMLFile1 = "LicenseFile_1.xml";
        String XMLFile2 = "LicenseFile_2.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document XMLDoc1 = builder.parse(new File(XMLFile1));
            Document XMLDoc2 = builder.parse(new File(XMLFile2));
            Document mergeDoc= mergeXMLFiles(XMLDoc1, XMLDoc2);
            //Writing Merged Details to XML File
            writeToXMLFile(mergeDoc, "MergedFile.xml");

            DateTimeFormatter dateObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            //Getting valid License for License File 1, Similar call can be made for License File 2
            XMLDoc1 = builder.parse(new File(XMLFile1));
            NodeList LicenseElement = XMLDoc1.getElementsByTagName("License");
            System.out.println("Getting Valid License List -------------------");
            Document validLicenseDoc=getLicense(XMLDoc1,LicenseElement, dateObj, true);
            //Writing Valid Licenses to XML File
            writeToXMLFile(validLicenseDoc, "ValidLicense.xml");

            //Getting Invalid License for License File 1, Similar call can be made for License File 2
            XMLDoc1 = builder.parse(new File(XMLFile1));
            LicenseElement = XMLDoc1.getElementsByTagName("License");
            System.out.println("\nGetting Invalid License List -------------------");
            Document invalidLicenseDoc=getLicense(XMLDoc1,LicenseElement, dateObj, false);
            //Writing Invalid Licenses to XML File
            writeToXMLFile(invalidLicenseDoc, "InvalidLicense.xml");

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
