package com.saachi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class License {

    public static Document getLicense(Document XMLDoc1,NodeList LicenseElement,DateTimeFormatter dateObj, boolean valid)
    {
        try {
            int License_Element_Index = 0;
            while( License_Element_Index <LicenseElement.getLength() )
            {
                Node license = LicenseElement.item(License_Element_Index);
                Element licenseElement = (Element) license;
                String License_Expiry_Date = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseDate = LocalDate.parse(License_Expiry_Date, dateObj);
                LocalDate currentDate = LocalDate.now();
                System.out.print(License_Expiry_Date +"  :");
                int diff = currentDate.compareTo(licenseDate);
                if(valid) {
                    if (diff > 0) {
                        System.out.print("Invalid License (Expiry Date):" + License_Expiry_Date);
                        licenseElement.getParentNode().removeChild(licenseElement);
                    } else License_Element_Index++;
                }
                else{
                    if(diff < 0) {
                        System.out.print("Valid License (Expiry Date): "+License_Expiry_Date);
                        licenseElement.getParentNode().removeChild(licenseElement);
                    }
                    else License_Element_Index++;
                }
                System.out.print("\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return XMLDoc1;
    }
}

