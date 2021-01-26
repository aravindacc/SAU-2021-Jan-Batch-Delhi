import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.io.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
public class merge {
   public static void main(String[] args) {
       try {
           File temp1 = new File("file1.xml");
           File temp2 = new File("file2.xml");
           DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = DBF.newDocumentBuilder();
           Document doc1 = dBuilder.parse(temp1);
           Document doc2 = dBuilder.parse(temp2);
           doc1.getDocumentElement().normalize();
           doc2.getDocumentElement().normalize();

           NodeList doc1CSR = doc1.getElementsByTagName("CSR_Producer");
           NodeList doc2CSR = doc2.getElementsByTagName("CSR_Producer");
           Document mergeFile = dBuilder.newDocument() ;
           Element root = mergeFile.createElement("CSR_Producer");
           mergeFile.appendChild(root);

           for(int temp = 0; temp < doc1CSR.getLength(); temp++) {
               Node curr_CSR1 = doc1CSR.item(temp);


               for(int i = 0 ; i < doc2CSR.getLength() ; i++){
                   Node curr_CSR2 = doc2CSR.item(i) ;
                   Element curr_Ele1 = (Element) curr_CSR1 ;
                   Element curr_Ele2 = (Element) curr_CSR2 ;


                   if( curr_Ele1.getAttribute("NIPR_Number").equals(curr_Ele2.getAttribute("NIPR_Number")) ){
                       NodeList NL = curr_Ele1.getElementsByTagName("License");


                       for(int j = 0 ; j < NL.getLength() ; j++){
                           Element LicenceElement1 = (Element)NL.item(j);
                           NodeList NL2 = curr_Ele2.getElementsByTagName("License");


                           for(int k = 0 ; k < NL2.getLength() ; k++){
                               Element LicenceElement2 = (Element)NL2.item(k) ;


                               if(LicenceElement1.getAttribute("State_Code").equals(LicenceElement2.getAttribute("State_Code"))
                                       && LicenceElement1.getAttribute("License_Number").equals(LicenceElement2.getAttribute("License_Number"))
                                       && LicenceElement1.getAttribute("License_Expiration_Date").equals(LicenceElement2.getAttribute("License_Expiration_Date"))){


                                   Node NewElement = mergeFile.importNode(LicenceElement2, true) ;
                                   root.appendChild(NewElement) ;


                                   writeFileOutput(mergeFile,"mergedXML.xml");


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


   public static final void writeFileOutput(Document xml, String filename) throws Exception {
       Transformer tf = TransformerFactory.newInstance().newTransformer();
       tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
   }
}