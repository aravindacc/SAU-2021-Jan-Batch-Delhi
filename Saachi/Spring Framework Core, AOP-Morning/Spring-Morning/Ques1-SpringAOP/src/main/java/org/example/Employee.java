package org.example;

import java.util.Map;
import java.util.Set;

public class Employee {
    private String name;
    private Map<String,String> contactDetails;
    private Set<Integer> projectId ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(Map<String, String> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Set<Integer> getProjectId() {
        return projectId;
    }

    public void setProjectId(Set<Integer> projectId) {
        this.projectId = projectId;
    }

    public void displayInfo(){
        System.out.println("Employee Name : "+this.name);
        System.out.println("Printing the Contact Details [Map values] corresponding to Employee Id:");
        for (Map.Entry<String, String> entry : contactDetails.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("Printing the Project Id's [Set values] assigned to the employee:");
        System.out.println(projectId);

    }

}
