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
public class MergeList {
   public static void main(String[] args) {
       try {
           
           File tmp1 = new File("C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/x1.txt");
           File tmp2 = new File("C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/x2.txt");
		   
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           
           Document doc1 = dBuilder.parse(tmp1);
           Document doc2 = dBuilder.parse(tmp2);
		   
           doc1.getDocumentElement().normalize();
           doc2.getDocumentElement().normalize();


           NodeList doc1_CSR = doc1.getElementsByTagName("CSR_Producer");
           NodeList doc2_CSR = doc2.getElementsByTagName("CSR_Producer");
		   
           Document mergeFile = dBuilder.newDocument() ;
           Element root = mergeFile.createElement("CSR_Producer");
           mergeFile.appendChild(root);






           for(int temp = 0; temp < doc1_CSR.getLength(); temp++) {
               Node currCSR1 = doc1_CSR.item(temp);


               for(int i = 0 ; i < doc2_CSR.getLength() ; i++){
				   
                   Node currCSR2 = doc2_CSR.item(i) ;
                   Element currElement1 = (Element) currCSR1 ;
                   Element currElement2 = (Element) currCSR2 ;


                   if( currElement1.getAttribute("NIPR_Number").equals(currElement2.getAttribute("NIPR_Number")) ){
					   
                       NodeList arr1 = currElement1.getElementsByTagName("License");


                       for(int j = 0 ; j < arr1.getLength() ; j++){
                           Element licenseElement1 = (Element)arr1.item(j);
                           NodeList arr2 = currElement2.getElementsByTagName("License");


                           for(int k = 0 ; k < arr2.getLength() ; k++){
                               Element licenseElement2 = (Element)arr2.item(k) ;


                               if(licenseElement1.getAttribute("State_Code").equals(licenseElement2.getAttribute("State_Code"))
                                       && licenseElement1.getAttribute("License_Number").equals(licenseElement2.getAttribute("License_Number"))
                                       && licenseElement1.getAttribute("License_Expiration_Date").equals(licenseElement2.getAttribute("License_Expiration_Date"))){


                                   Node newEle = mergeFile.importNode(licenseElement2, true) ;
                                   root.appendChild(newEle) ;


                                   pprint(mergeFile,"C:/Users/hp/Desktop/Accolite/Assignments/Assignments/Advance Java - Evening/mergedFile.txt");


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


   public static final void pprint(Document xml, String filename) throws Exception {
       Transformer tf = TransformerFactory.newInstance().newTransformer();
       tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
   }
}
