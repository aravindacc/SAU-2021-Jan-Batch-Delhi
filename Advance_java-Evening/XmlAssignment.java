import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.SocketOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class XmlAssignment {
	
	
	
	public static void printFile(Document doc1, String newFile) 
	{
		try
		{
			TransformerFactory tFactory = TransformerFactory.newInstance();
	        Transformer transformer = tFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        DOMSource source = new DOMSource(doc1);
	        StreamResult result = new StreamResult(new StringWriter());
	        transformer.transform(source, result);

	        Writer output = new BufferedWriter(new FileWriter(newFile));
	        String xmlOutput = result.getWriter().toString();
	        output.write(xmlOutput);
	        output.close();
		}
		catch (Exception e) 
		{

            e.printStackTrace();
        }
	}
	
    public static void mergeinputs(String input1, String input2, String newFile){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc1 = builder.parse(new File(input1));
            Document doc2 = builder.parse(new File(input2));

            NodeList firstInput = doc1.getElementsByTagName("CSR_Producer");
            NodeList secondInput = doc2.getElementsByTagName("CSR_Producer");

            for(int i = 0; i < firstInput.getLength(); i++) 
            {
                Node n1 = firstInput.item(i);
    
                    Element e1 = (Element) n1;
                    boolean sameNIPR = false;

                for (int j = 0; j < secondInput.getLength(); j++) 
                {
                    Node n2 = secondInput.item(j);
                    
                    Element e2 = (Element) n2;

                    if (e1.getAttribute("NIPR_Number").equals(e2.getAttribute("NIPR_Number"))) {
                        sameNIPR = true;
                        NodeList element1 = e1.getChildNodes();
                        NodeList element2 = e2.getChildNodes();

                        for (int k = 0; k < element1.getLength(); k++) 
                        {
                            Node d1 = element1.item(k);
                            boolean lMatched = false;

                            if(d1.getNodeType() == Node.ELEMENT_NODE) 
                            {
                                Element d1Element = (Element) d1;
                                for (int y = 0; y < element2.getLength(); y++) 
                                {
                                    Node d2 = element2.item(y);
                                    if (d2.getNodeType() == Node.ELEMENT_NODE) 
                                    {
                                        Element d2Element = (Element) d2;
                                        if ((d1Element.getAttribute("Date_Status_Effective").equals(d2Element.getAttribute("Date_Status_Effective")))
                                        && (d1Element.getAttribute("State_Code").equals(d2Element.getAttribute("State_Code")))
                                            && (d1Element.getAttribute("License_Number").equals(d2Element.getAttribute("License_Number")))) 
                                        {

                                            lMatched=true;
                                            NodeList childNodes = d2.getChildNodes();
                                            for (int x = 0; x < childNodes.getLength(); x++) 
                                            {
                                                Node n = (Node) doc1.importNode(childNodes.item(x),true);
                                                d1Element.appendChild(n);
                                            }
                                        }

                                    }
                                }
                                if(lMatched == false)
                                {
                                    d1.getParentNode().removeChild(d1);
                                }
                            }

                        }
                    }

                }
                if(sameNIPR==false)
                {
                	n1.getParentNode().removeChild(n1);
                }
            }
            
            printFile(doc1, newFile);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void fileValidity (String input, boolean findValid, String newFile)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try 
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(input));
            NodeList n1 = doc.getElementsByTagName("License");

            for(int i = 0; i <n1.getLength(); i++) 
            {
                Node license = n1.item(i);
                Element l1 = (Element) license;

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String a = l1.getAttribute("License_Expiration_Date");
                LocalDate licenseDate = LocalDate.parse(a, myFormatObj);

                LocalDate today = LocalDate.now();

                int d = today.compareTo(licenseDate);
                if((d > 0 && findValid == true) || (d < 0 && findValid == false)) 
                {
                    l1.getParentNode().removeChild(l1);
                }               
            }

            printFile(doc, newFile);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    

    public static void main(String[] args) {
        String input1 = "src/input1.xml";
        String input2 = "src/input2.xml";
        String newFile = "mergedFile.xml";
        mergeinputs(input1, input2, newFile);
        fileValidity(newFile, true, "validFile.xml");
        fileValidity(newFile, false, "invalidFile.xml");
    
    }
}