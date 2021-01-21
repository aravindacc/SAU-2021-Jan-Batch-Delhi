import java.util.* ;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.transform.dom.DOMSource;
import java.text.SimpleDateFormat;
import java.io.*;
public class ValidInvalidLicenses {
   public static void main(String[] args) {
       try {
           
           
           File tmp1 = new File("C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/x1.txt");
           File tmp2 = new File("C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/x2.txt");
           
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          
           Document validFile = dBuilder.newDocument();
           Document invalidFile = dBuilder.newDocument();
          
           
           Document doc1 = dBuilder.parse(tmp1);
           Document doc2 = dBuilder.parse(tmp2);



           doc1.getDocumentElement().normalize();
           doc2.getDocumentElement().normalize();




           NodeList doc1_CSR = doc1.getElementsByTagName("CSR_Producer");
           NodeList doc2_CSR = doc2.getElementsByTagName("CSR_Producer");




           Element validRoot = validFile.createElement("CSR_Producer");
           validFile.appendChild(validRoot);


           Element invalidRoot = invalidFile.createElement("CSR_Producer");
           invalidFile.appendChild(invalidRoot);


         for (int i = 0; i < doc1_CSR.getLength(); i++) {
               Element currentEle = (Element) doc1_CSR.item(i);
               NodeList licenseList = currentEle.getElementsByTagName("License");


               for (int j = 0; j < licenseList.getLength(); j++) {
                   Element curr_license = (Element) licenseList.item(j);
                   String date = curr_license.getAttribute("License_Expiration_Date");
                   Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                   Date curr = new Date();


                   if (expiry.compareTo(curr) > 0) {
                       Node newEle = validFile.importNode(curr_license, true);
                       validRoot.appendChild(newEle);
                       pprint(validFile, "C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/validLicenses.txt");
                   } else {
                       Node newEle = invalidFile.importNode(curr_license, true);
                       invalidRoot.appendChild(newEle);
                       pprint(invalidFile, "C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/invalidLicenses.txt");
                   }
               }
           }




           for (int i = 0; i < doc2_CSR.getLength(); i++) {
               Element currentEle = (Element) doc2_CSR.item(i);
               NodeList licenseList = currentEle.getElementsByTagName("License");


               for (int j = 0; j < licenseList.getLength(); j++) {
                   Element curr_license = (Element) licenseList.item(j);
                   String date = curr_license.getAttribute("License_Expiration_Date");
                   Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                   Date curr = new Date();


                   if (expiry.compareTo(curr) > 0) {
                       Node newEle = validFile.importNode(curr_license, true);
                       validRoot.appendChild(newEle);
                       pprint(validFile, "C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/validLicenses.txt");
                   } else {
                       Node newEle = invalidFile.importNode(curr_license, true);
                       invalidRoot.appendChild(newEle);
                       pprint(invalidFile, "C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/invalidLicenses.txt");
                   }
               }
           }   
} catch (Exception e) {
           e.printStackTrace();
           System.out.println();
       }
   }


   public static final void pprint(Document xml, String filename) throws Exception {
       Transformer tf = TransformerFactory.newInstance().newTransformer();
       tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
   }
}
