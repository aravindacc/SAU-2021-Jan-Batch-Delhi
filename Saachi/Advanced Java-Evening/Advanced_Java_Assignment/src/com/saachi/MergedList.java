package com.saachi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class MergedList {

    public static Document mergeXMLFiles(Document XMLDoc1, Document XMLDoc2){
        try {
            NodeList csr_producer_1 = XMLDoc1.getElementsByTagName("CSR_Producer");
            NodeList csr_producer_2 = XMLDoc2.getElementsByTagName("CSR_Producer");

            for(int producer_index_1 = 0; producer_index_1 <csr_producer_1.getLength(); producer_index_1++) {
                Node csr1 = csr_producer_1.item(producer_index_1);
                Element csr_Element_1 = (Element) csr1;
                boolean csr_matched = false;

                for (int producer_index_2 = 0; producer_index_2 < csr_producer_2.getLength(); producer_index_2++) {
                    Node csr2 = csr_producer_2.item(producer_index_2);
                    Element csr_Element_2 = (Element) csr2;

                    if (csr_Element_1.getAttribute("NIPR_Number").equals(csr_Element_2.getAttribute("NIPR_Number"))) {
                        NodeList csr1ElementDetails = csr_Element_1.getChildNodes();
                        NodeList csr2ElementDetails = csr_Element_2.getChildNodes();
                        csr_matched = true;

                        for (int csr_1_Element_Index = 0; csr_1_Element_Index < csr1ElementDetails.getLength(); csr_1_Element_Index++) {
                            Node csr_detail_1 = csr1ElementDetails.item(csr_1_Element_Index);
                            boolean license_Matched = false;

                            if(csr_detail_1.getNodeType() == Node.ELEMENT_NODE) {
                                Element csr_first_detail = (Element) csr_detail_1;
                                for (int csr_2_Element_Index = 0; csr_2_Element_Index < csr2ElementDetails.getLength(); csr_2_Element_Index++) {
                                    Node csr_detail_2 = csr2ElementDetails.item(csr_2_Element_Index);
                                    if (csr_detail_2.getNodeType() == Node.ELEMENT_NODE) {
                                        Element csr_second_detail = (Element) csr_detail_2;
                                        if ((csr_first_detail.getAttribute("Date_Status_Effective").equals(csr_second_detail.getAttribute("Date_Status_Effective")))
                                                && (csr_first_detail.getAttribute("State_Code").equals(csr_second_detail.getAttribute("State_Code")))
                                                && (csr_first_detail.getAttribute("License_Number").equals(csr_second_detail.getAttribute("License_Number")))) {

                                            license_Matched = true;
                                            NodeList childNodes = csr_detail_2.getChildNodes();
                                            for (int csr_2_ChildIndex = 0; csr_2_ChildIndex < childNodes.getLength(); csr_2_ChildIndex++) {
                                                Node n = (Node) XMLDoc1.importNode(childNodes.item(csr_2_ChildIndex),true);
                                                csr_first_detail.appendChild(n);
                                            }
                                        }
                                    }
                                }
                                if(license_Matched==false)
                                {
                                    csr_detail_1.getParentNode().removeChild(csr_detail_1);
                                }
                            }
                        }
                    }
                }
                if(csr_matched==false)
                {
                    csr1.getParentNode().removeChild(csr1);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return XMLDoc1;
    }
}
