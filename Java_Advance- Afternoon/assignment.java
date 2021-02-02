import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.io.*;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;

public class assignment {

    public static final void save(Document xml, String filename) throws Exception
    {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.transform(new DOMSource(xml), new StreamResult(new File(filename)));
    }


    public static void main(String[] args){
                try
                {
                    //Importing xml files
                    File temp1 = new File("Input1.xml");
                    File temp2 = new File("Input2.xml");

                    //Creating document builder
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                    //Creating document from file
                    Document d1 = dBuilder.parse(temp1);
                    Document d2 = dBuilder.parse(temp2);

                    //Extracting root name
                    Document validFile = dBuilder.newDocument();
                    Document invalidFile = dBuilder.newDocument();
                    Document mergeFile = dBuilder.newDocument() ;

                    d1.getDocumentElement().normalize();
                    d2.getDocumentElement().normalize();

                    NodeList document1 = d1.getElementsByTagName("CSR_Producer");
                    NodeList document2 = d2.getElementsByTagName("CSR_Producer");

                    Element validRoot = validFile.createElement("CSR_Producer");
                    validFile.appendChild(validRoot);

                    Element invalidRoot = invalidFile.createElement("CSR_Producer");
                    invalidFile.appendChild(invalidRoot);

                    Element root = mergeFile.createElement("CSR_Producer");
                    mergeFile.appendChild(root);

                    //Filtering of valid and invalid licenses from file1
                    for (int i = 0; i < document1.getLength(); i++)
                    {
                        Element currentElement = (Element) document1.item(i);
                        NodeList licenseList = currentElement.getElementsByTagName("License");

                        for (int j = 0; j < licenseList.getLength(); j++)
                        {
                            Element current_license = (Element) licenseList.item(j);
                            String status=current_license.getAttribute("License_Status");
	                if (status.equals("Y"))
	                {
	                	Node newElement = validFile.importNode(current_license, true);
	                    validRoot.appendChild(newElement);
	                    save(validFile, "valid.txt");
	                    }

	                else
	                {
	                	Node newElement = invalidFile.importNode(current_license, true);
	                    invalidRoot.appendChild(newElement);
	                    save(invalidFile, "invalid.txt");
	                    }
                        }
                    }

	        //Filtering of valid and invalid licenses from file2
	        for (int i = 0; i < document2.getLength(); i++)
	        {
	        	Element currentElement = (Element) document2.item(i);
	            NodeList licenseList = currentElement.getElementsByTagName("License");

	            for (int j = 0; j < licenseList.getLength(); j++)
	            {
	            	Element currentLicense = (Element) licenseList.item(j);
	                String status = currentLicense.getAttribute("License_Status");


	                if (status.equals("Y"))
	                {
	                	Node newElement = validFile.importNode(currentLicense, true);
	                    validRoot.appendChild(newElement);
	                    save(validFile, "valid.txt");
	                    }
	                else
	                {
	                	Node newElement = invalidFile.importNode(currentLicense, true);
	                    invalidRoot.appendChild(newElement);
	                    save(invalidFile, "invalid.txt");
	                    }
	                }
	            }

	        //Merging of both files based on given keys
	        for(int temp = 0; temp < document1.getLength(); temp++)
	        {
	        	Node element1 = document1.item(temp);

	        	for(int i = 0 ; i < document2.getLength() ; i++)
	        	{
	        		Node element2 = document2.item(i) ;
	                Element currentElement1 = (Element) element1 ;
	                Element currentElement2 = (Element) element2 ;

	                if( currentElement1.getAttribute("NIPR_Number").equals(currentElement2.getAttribute("NIPR_Number")) )
	                {

	                	NodeList list1 = currentElement1.getElementsByTagName("License");

	                	for(int j = 0 ; j < list1.getLength() ; j++)
	                	{
	                		Element licenseElement1 = (Element)list1.item(j);
	                        NodeList list2 = currentElement2.getElementsByTagName("License");

	                        for(int k = 0 ; k < list2.getLength() ; k++)
	                        {
	                        	Element licenseElement2 = (Element)list2.item(k) ;

	                        	if(licenseElement1.getAttribute("State_Code").equals(licenseElement2.getAttribute("State_Code"))
	                                && licenseElement1.getAttribute("License_Number").equals(licenseElement2.getAttribute("License_Number")))
	                        	{
	                        		Node newElement = mergeFile.importNode(licenseElement2, true) ;
	                                root.appendChild(newElement) ;

	                                save(mergeFile,"merge.txt");
	                                }
	                        	}
	                        }
	                   }
	               }
	           }

                }

                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println();
                }
            }


        }








