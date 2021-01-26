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
public class ValidInvalidGenerator {
   public static void main(String[] args) {
       try {
         
           File F1 = new File("file1.xml");
           File F2 = new File("file2.xml");
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         
           Document d1 = dBuilder.parse(F1);
           Document d2 = dBuilder.parse(F2);


           Document Valid = dBuilder.newDocument();
           Document Invalid = dBuilder.newDocument();




           d1.getDocumentElement().normalize();
           d2.getDocumentElement().normalize();




           NodeList D1CSR = d1.getElementsByTagName("CSR_Producer");
           NodeList D2CSR = d2.getElementsByTagName("CSR_Producer");




           Element validRoot = Valid.createElement("CSR_Producer");
           Valid.appendChild(validRoot);


           Element invalidRoot = Invalid.createElement("CSR_Producer");
           Invalid.appendChild(invalidRoot);


         for (int i = 0; i < D1CSR.getLength(); i++) {
               Element CurrentElement = (Element) D1CSR.item(i);
               NodeList ListL = CurrentElement.getElementsByTagName("License");


               for (int j = 0; j < ListL.getLength(); j++) {
                   Element curr_license = (Element) ListL.item(j);
                   String date = curr_license.getAttribute("License_Expiration_Date");
                   Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                   Date curr = new Date();


                   if (expiry.compareTo(curr) > 0) {
                       Node NewElement = Valid.importNode(curr_license, true);
                       validRoot.appendChild(NewElement);
                      writeFileOutput(Valid, "Valid.xml");
                   } else {
                       Node NewElement = Invalid.importNode(curr_license, true);
                       invalidRoot.appendChild(NewElement);
                      writeFileOutput(Invalid, "Invalid.xml");
                   }
               }
           }




           for (int i = 0; i < D2CSR.getLength(); i++) {
               Element CurrentElement = (Element) D2CSR.item(i);
               NodeList ListL = CurrentElement.getElementsByTagName("License");


               for (int j = 0; j < ListL.getLength(); j++) {
                   Element curr_license = (Element) ListL.item(j);
                   String date = curr_license.getAttribute("License_Expiration_Date");
                   Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                   Date curr = new Date();


                   if (expiry.compareTo(curr) > 0) {
                       Node NewElement = Valid.importNode(curr_license, true);
                       validRoot.appendChild(NewElement);
                      writeFileOutput(Valid, "Valid.xml");
                   } else {
                       Node NewElement = Invalid.importNode(curr_license, true);
                       invalidRoot.appendChild(NewElement);
                      writeFileOutput(Invalid, "Invalid.xml");
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

