import java.util.* ; 
import java.text.SimpleDateFormat;
import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class Main{
	public static void main(String[] args){
		try{
			File inputFile1 = new File("/Users/arun/Desktop/Accolite/Assignments work/advance-java/xml1.txt");
	         File inputFile2 = new File("/Users/arun/Desktop/Accolite/Assignments work/advance-java/xml2.txt");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

	         Document d1 = dBuilder.parse(inputFile1);
	         Document d2 = dBuilder.parse(inputFile2);
	         //Document merged_doc = dBuilder.newDocument() ;
	         Document validDoc = dBuilder.newDocument() ;
	         Document invalidDoc = dBuilder.newDocument() ;



	         d1.getDocumentElement().normalize();
	         d2.getDocumentElement().normalize();


	         NodeList doc1_CSR = d1.getElementsByTagName("CSR_Producer");
	         NodeList doc2_CSR = d2.getElementsByTagName("CSR_Producer");


	         Element validRoot = validDoc.createElement("CSR_Producer");
	         validDoc.appendChild(validRoot);
	         
	         Element invalidRoot = invalidDoc.createElement("CSR_Producer");
	         invalidDoc.appendChild(invalidRoot);



	         for(int i = 0 ; i < doc1_CSR.getLength() ; i++){
                Element curr_ele = (Element)doc1_CSR.item(i) ;
                NodeList license_list = curr_ele.getElementsByTagName("License") ;

                for(int j = 0 ; j < license_list.getLength() ; j++){
                    Element curr_license =  (Element)license_list.item(j) ;
                    String date = curr_license.getAttribute("License_Expiration_Date");
                    Date expiry = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                    Date curr = new Date() ;

                    if(expiry.compareTo(curr) > 0){
                        Node newEle = validDoc.importNode(curr_license, true) ;
                        validRoot.appendChild(newEle) ;
                        prettyPrint(validDoc,"/Users/arun/Desktop/Accolite/Assignments work/advance-java/valid.txt");
                    }else{
                        Node newEle = invalidDoc.importNode(curr_license, true) ;
                        invalidRoot.appendChild(newEle) ;
                        prettyPrint(invalidDoc,"/Users/arun/Desktop/Accolite/Assignments work/advance-java/invalid.txt");
                    }
                }
            }




	       //  Element root = merged_doc.createElement("CSR_Producer");
	        // merged_doc.appendChild(root);


	        /* for(int tmp=0;tmp<doc1_CSR.getLength();tmp++){
	         	Node curr_Csr1 = doc1_CSR.item(tmp);

	         	for(int i = 0 ; i < doc2_CSR.getLength() ; i++){
	            	 Node curr_CSR2 = doc2_CSR.item(i) ; 
	            	 Element curr_Ele1 = (Element) curr_CSR1 ; 
	            	 Element curr_Ele2 = (Element) curr_CSR2 ;
	            	 
	            	 if( curr_Ele1.getAttribute("NIPR_Number").equals(curr_Ele2.getAttribute("NIPR_Number")) ){


	         }

		} */
	}
	catch(Exception e){
            e.printStackTrace();
            System.out.println() ;
        }
}

public static final void prettyPrint(Document xml , String filename) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }




    
