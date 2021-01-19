import java.util.* ;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.text.SimpleDateFormat;
import java.io.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
public class Main {
    public static void main(String[] args) {
        try {
            //Initialize file names
            File temp1 = new File("/Users/arun/Desktop/Accolite/Assignments work/Advanced java - evening/javaxml/xm1.txt");
            File temp2 = new File("/Users/arun/Desktop/Accolite/Assignments work/Advanced java - evening/javaxml/xml2.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Initialize documents name
            Document d1 = dBuilder.parse(temp1);
            Document d2 = dBuilder.parse(temp2);
            d1.getDocumentElement().normalize();
            d2.getDocumentElement().normalize();

            NodeList doc1_CSR = d1.getElementsByTagName("CSR_Producer");
            NodeList doc2_CSR = d2.getElementsByTagName("CSR_Producer");
            Document mergeFile = dBuilder.newDocument() ;
            Element root = mergeFile.createElement("CSR_Producer");
            mergeFile.appendChild(root);



            for(int temp = 0; temp < doc1_CSR.getLength(); temp++) {
                Node curr_CSR1 = doc1_CSR.item(temp);

                for(int i = 0 ; i < doc2_CSR.getLength() ; i++){
                    Node curr_CSR2 = doc2_CSR.item(i) ;
                    Element curr_Ele1 = (Element) curr_CSR1 ;
                    Element curr_Ele2 = (Element) curr_CSR2 ;

                    if( curr_Ele1.getAttribute("NIPR_Number").equals(curr_Ele2.getAttribute("NIPR_Number")) ){
                        NodeList arr1 = curr_Ele1.getElementsByTagName("License");

                        for(int j = 0 ; j < arr1.getLength() ; j++){
                            Element license_ele1 = (Element)arr1.item(j);
                            NodeList arr2 = curr_Ele2.getElementsByTagName("License");

                            for(int k = 0 ; k < arr2.getLength() ; k++){
                                Element license_ele2 = (Element)arr2.item(k) ;

                                if(license_ele1.getAttribute("State_Code").equals(license_ele2.getAttribute("State_Code"))
                                        && license_ele1.getAttribute("License_Number").equals(license_ele2.getAttribute("License_Number"))
                                        && license_ele1.getAttribute("License_Expiration_Date").equals(license_ele2.getAttribute("License_Expiration_Date"))){

                                    Node newEle = mergeFile.importNode(license_ele2, true) ;
                                    root.appendChild(newEle) ;

                                    prettyPrint(mergeFile,"/Users/arun/Desktop/Accolite/Assignments work/Advanced java - evening/javaxml/merge.txt");

                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public static final void prettyPrint(Document xml, String filename) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }
}
