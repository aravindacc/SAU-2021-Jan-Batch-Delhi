import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseXML {

    static Document licence1, licence2, validLic, invalidLic, mergedFile;


    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException, TransformerException {

        loadDocuments();

        findValidInvalidLicensesInFile(licence1, 'c');
        findValidInvalidLicensesInFile(licence2, 'g');

        loadDocuments();

        mergeFiles();
    }

    // loads document from files
    private static void loadDocuments() throws ParserConfigurationException, IOException, SAXException {

        File file1 = new File(ParseXML.class.getResource("License1.xml").getPath() );

        File file2 = new File(ParseXML.class.getResource("License2.xml").getPath() );

        System.out.println(file1.getPath());
        System.out.println(file2.getPath());
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        dBuilder = dbFactory.newDocumentBuilder();
        licence1 = dBuilder.parse(file1);
        licence2 = dBuilder.parse(file2);

        licence1.getDocumentElement().normalize();
        licence2.getDocumentElement().normalize();

        validLic = dBuilder.newDocument();
        invalidLic = dBuilder.newDocument();
        mergedFile = dBuilder.newDocument();

    }

    // write document to file
    private static void writeFile(String fileName, Document doc) throws TransformerException, IOException {
        File file = new File("src/"+fileName);
        file.createNewFile();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(file));
    }

    private static void findValidInvalidLicensesInFile(Document file, char mode) throws ParseException, TransformerException, IOException {
        // license file xml nodes
        NodeList licCSR = file.getElementsByTagName("CSR_Producer");

        // if writing first time 'c' create mode else 'g' get mode
        Element validRoot, invalidRoot;
        if (mode == 'c') {
            validRoot = validLic.createElement("CSR_Producer");
            validLic.appendChild(validRoot);
            invalidRoot = invalidLic.createElement("CSR_Producer");
            invalidLic.appendChild(invalidRoot);
        } else {
            validRoot = (Element) validLic.getElementsByTagName("CSR_Producer").item(0);
            invalidRoot = (Element) invalidLic.getElementsByTagName("CSR_Producer").item(0);
        }


        // for each CSR producer
        for (int i=0; i<licCSR.getLength(); i++) {
            NodeList licenses = ((Element)licCSR.item(i)).getElementsByTagName("License");

            // for each licence
            for (int j=0; j<licenses.getLength(); j++) {

                Element lic =  (Element) licenses.item(j);

                String date = lic.getAttribute("License_Expiration_Date");
                Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                Date curDate = new Date();


                if (expiry.compareTo(curDate) > 0) {
                    Node newEle = validLic.importNode(lic, true);
                    validRoot.appendChild(newEle);
                    writeFile("ValidLicenses.xml", validLic);
                } else {
                    Node newEle = invalidLic.importNode(lic, true);
                    invalidRoot.appendChild(newEle);
                    writeFile("InvalidLicenses.xml", invalidLic);
                }
            }
        }
    }

    private static void mergeFiles() throws TransformerException, IOException {

        NodeList lic1CSR = licence1.getElementsByTagName("CSR_Producer");
        NodeList lic2CSR = licence2.getElementsByTagName("CSR_Producer");

        Element root = mergedFile.createElement("CSR_Producer");
        mergedFile.appendChild(root);

        // for each CSR
        for(int c = 0; c < lic1CSR.getLength(); c++) {
            Element csrEle1 = (Element) lic1CSR.item(c) ;

            // for each CSR in other file
            for(int i = 0 ; i < lic2CSR.getLength() ; i++){
                Element csrEle2 = (Element) lic2CSR.item(i) ;

                // if csr nipr match check for licence
                if( csrEle1.getAttribute("NIPR_Number").equals(csrEle2.getAttribute("NIPR_Number")) ){
                    NodeList licList1 = csrEle1.getElementsByTagName("License");

                    // for each license in 1
                    for(int j = 0 ; j < licList1.getLength() ; j++){
                        Element licEle1 = (Element)licList1.item(j);
                        NodeList licList2 = csrEle2.getElementsByTagName("License");

                        // for each licence in 2
                        for(int k = 0 ; k < licList2.getLength() ; k++){
                            Element licEle2 = (Element)licList2.item(k) ;

                            // if state code, licence number & expiry match append it to merged file
                            if(licEle1.getAttribute("State_Code").equals(licEle2.getAttribute("State_Code"))  &&
                                    licEle1.getAttribute("License_Number").equals(licEle2.getAttribute("License_Number")) &&
                                    licEle1.getAttribute("License_Expiration_Date").equals(licEle2.getAttribute("License_Expiration_Date"))){

                                Node newLic = mergedFile.importNode(licEle2, true) ;
                                root.appendChild(newLic) ;
                                writeFile("MergedFile.xml", mergedFile);
                            }
                        }
                    }
                }
            }
        }
    }
}