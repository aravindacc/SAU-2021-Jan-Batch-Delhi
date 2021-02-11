import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class xmlParsing {


    //Part 1
    public static void mergeFiles(File file1, File file2) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docbuilder = factory.newDocumentBuilder();

            Document Doc1 = docbuilder.parse(file1);
            Document Doc2 = docbuilder.parse(file2);
            Document mergeFile = docbuilder.newDocument();

            NodeList ndDoc1 = Doc1.getElementsByTagName("CSR_Producer");
            NodeList ndDoc2 = Doc2.getElementsByTagName("CSR_Producer");

            Element root = mergeFile.createElement("CSR_Producer");
            mergeFile.appendChild(root);

            for (int i = 0; i < ndDoc1.getLength(); i++) {
                Node node1 = ndDoc1.item(i);

                if (node1.getNodeType() == Node.ELEMENT_NODE) {
                    Element ele1 = (Element) node1;

                    for (int j = 0; j < ndDoc2.getLength(); j++) {
                        Node node2 = ndDoc2.item(j);

                        if (node1.getNodeType() == Node.ELEMENT_NODE) {
                            Element ele2 = (Element) node2;

                            if (isSameNIPR(ele1, ele2)) {
                                NodeList licenseList1 = ele1.getChildNodes();
                                NodeList licenseList2 = ele2.getChildNodes();

                                for (int k = 0; k < licenseList1.getLength(); k++) {
                                    Node license1 = licenseList1.item(k);

                                    if (license1.getNodeType() == Node.ELEMENT_NODE) {
                                        Element license1Element = (Element) license1;

                                        for (int l = 0; l < licenseList2.getLength(); l++) {
                                            Node license2 = licenseList2.item(l);

                                            if (license2.getNodeType() == Node.ELEMENT_NODE) {
                                                Element licence2Element = (Element) license2;

                                                if ((license1Element.getAttribute("Date_Status_Effective")
                                                        .equals(licence2Element.getAttribute("Date_Status_Effective")))
                                                        && (license1Element.getAttribute("State_Code")
                                                                .equals(licence2Element.getAttribute("State_Code")))
                                                        && (license1Element.getAttribute("License_Number").equals(
                                                                licence2Element.getAttribute("License_Number")))) {
                                                    Node licenceToAdded = mergeFile.importNode(licence2Element, true);
                                                    root.appendChild(licenceToAdded);
                                                    writeToFile(mergeFile, "mergedXML.xml");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSameNIPR(Element csr1Element, Element csr2Element) {
        return (csr1Element.getAttribute("NIPR_Number").equals(csr2Element.getAttribute("NIPR_Number")));
    }

    //Part 2

    public static void valid_Invalid(File file1, File file2) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docbuilder = factory.newDocumentBuilder();
            Document doc1 = docbuilder.parse(file1);
            Document doc2 = docbuilder.parse(file2);

            Document validDoc = docbuilder.newDocument();
            Document invalidDoc = docbuilder.newDocument();
            Element validRoot = validDoc.createElement("Valid_Licences");
            validDoc.appendChild(validRoot);
            Element invalidRoot = invalidDoc.createElement("Invalid_Licences");
            invalidDoc.appendChild(invalidRoot);

            NodeList ndListFile1 = doc1.getElementsByTagName("License");
            NodeList ndListFile2 = doc2.getElementsByTagName("License");

            for (int i = 0; i < ndListFile1.getLength(); i++) {
                Node license = ndListFile1.item(i);
                Element licenseElement1 = (Element) license;

                int diff = DifferenceCalculator(licenseElement1);

                if (diff < 0) {
                    // LICENSE is VALID
                    Node licenceToAddedAsValid = validDoc.importNode(licenseElement1, true);
                    validRoot.appendChild(licenceToAddedAsValid);
                } else { // LICENSE is INVALID
                    Node licenceToAddedAsInvalid = invalidDoc.importNode(licenseElement1, true);
                    invalidRoot.appendChild(licenceToAddedAsInvalid);
                }
            }

            for (int i = 0; i < ndListFile2.getLength(); i++) {
                Node license2 = ndListFile2.item(i);
                Element licenseElement2 = (Element) license2;

                int diff = DifferenceCalculator(licenseElement2);

                
                if (diff < 0) {
                    //valid
                    Node licenceToAddedAsValid = validDoc.importNode(licenseElement2, true);
                    validRoot.appendChild(licenceToAddedAsValid);
                } else { //invalid
                    Node licenceToAddedAsInvalid = invalidDoc.importNode(licenseElement2, true);
                    invalidRoot.appendChild(licenceToAddedAsInvalid);
                }
            }
            // Creating file for VALID LICENSES
            writeToFile(validDoc, "validXML.xml");

            // Creating file for INVALID LICENSES
            writeToFile(invalidDoc, "invalidXML.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static int DifferenceCalculator(Element licenseElement) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
        LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);
        LocalDate today = LocalDate.now();
        int diff = today.compareTo(licenseExpirationDate);
        return diff;

    }

    public static final void writeToFile(Document xml, String filename) throws Exception {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }

    public static void main(String[] args) {
        try {
            File file1 = new File("file1.xml");
            File file2 = new File("file2.xml");

            mergeFiles(file1, file2);
            valid_Invalid(file1, file2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}