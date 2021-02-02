package com.company;

        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;

        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.transform.OutputKeys;
        import javax.xml.transform.Transformer;
        import javax.xml.transform.TransformerFactory;
        import javax.xml.transform.dom.DOMSource;
        import javax.xml.transform.stream.StreamResult;
        import java.io.*;
        import java.time.LocalDate;
        import java.time.format.DateTimeFormatter;


public class Main {

    public static void mergeFiles(String file1, String file2){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File(file1));
            Document doc2 = builder.parse(new File(file2));

            NodeList ndListFirstFile = doc.getElementsByTagName("CSR_Producer");
            NodeList ndListSecondFile = doc2.getElementsByTagName("CSR_Producer");

            for(int i = 0; i <ndListFirstFile.getLength(); i++) {
                Node csr1 = ndListFirstFile.item(i);
                Element csr1Element = (Element) csr1;
                boolean csr_matched = false;

                for (int j = 0; j < ndListSecondFile.getLength(); j++) {
                    Node csr2 = ndListSecondFile.item(j);
                    Element csr2Element = (Element) csr2;

                    if (csr1Element.getAttribute("NIPR_Number").equals(csr2Element.getAttribute("NIPR_Number"))) {

                        csr_matched = true;
                        NodeList csr1ElementDetails = csr1Element.getChildNodes();
                        NodeList csr2ElementDetails = csr2Element.getChildNodes();

                        for (int k = 0; k < csr1ElementDetails.getLength(); k++) {
                            Node detail1 = csr1ElementDetails.item(k);
                            boolean licenseMatched = false;

                            if(detail1.getNodeType() == Node.ELEMENT_NODE) {
                                Element detail1Element = (Element) detail1;
                                for (int l = 0; l < csr2ElementDetails.getLength(); l++) {
                                    Node detail2 = csr2ElementDetails.item(l);
                                    if (detail2.getNodeType() == Node.ELEMENT_NODE) {
                                        Element detail2Element = (Element) detail2;
                                        if ((detail1Element.getAttribute("Date_Status_Effective").equals(detail2Element.getAttribute("Date_Status_Effective")))
                                                && (detail1Element.getAttribute("State_Code").equals(detail2Element.getAttribute("State_Code")))
                                                && (detail1Element.getAttribute("License_Number").equals(detail2Element.getAttribute("License_Number")))) {

                                            licenseMatched = true;
                                            NodeList childNodes = detail2.getChildNodes();
                                            for (int m = 0; m < childNodes.getLength(); m++) {
                                                Node n = (Node) doc.importNode(childNodes.item(m),true);
                                                detail1Element.appendChild(n);
                                            }
                                        }

                                    }
                                }
                                if(licenseMatched==false)
                                {
                                    detail1.getParentNode().removeChild(detail1);
                                    k--; // just deleted an element due to which indices get changed
                                }
                            }

                        }
                    }

                }
                if(csr_matched==false)
                {
                    csr1.getParentNode().removeChild(csr1);
                    i--; // just deleted an element due to which indices get changed
                }
            }
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("mergedFile.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void writeValid(String file)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(file));
            NodeList ndListFirstFile = doc.getElementsByTagName("License");

            for(int i = 0; i <ndListFirstFile.getLength(); i++) {
                Node license = ndListFirstFile.item(i);
                Element licenseElement = (Element) license;

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                String d = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseDate = LocalDate.parse(d, myFormatObj);

                LocalDate today = LocalDate.now();

                int diff = today.compareTo(licenseDate);
                if(diff > 0) {
                    //delete
                    licenseElement.getParentNode().removeChild(licenseElement);
                }
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("validLicense.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void writeInValid(String file)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(file));
            NodeList ndListFirstFile = doc.getElementsByTagName("License");

            for(int i = 0; i <ndListFirstFile.getLength(); i++) {
                Node license = ndListFirstFile.item(i);
                Element licenseElement = (Element) license;

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String d = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseDate = LocalDate.parse(d, myFormatObj);

                LocalDate today = LocalDate.now();

                int diff = today.compareTo(licenseDate);
                if(diff < 0) {
                    //delete
                    licenseElement.getParentNode().removeChild(licenseElement);
                }
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);

            Writer output = new BufferedWriter(new FileWriter("inValidLicense.xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file1 = "file1.xml";
        String file2 = "file2.xml";

        mergeFiles(file1, file2);

        System.out.println("Merging files 1 and 2");

        writeValid(file1);
        System.out.println("Writing valid licenses of file 1");

        writeInValid(file1);
        System.out.println("Writing invalid licenses of file 1");

    }
}
