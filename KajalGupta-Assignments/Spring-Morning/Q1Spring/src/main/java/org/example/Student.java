package org.example;

import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private Map<String,String> parents;
    private Set<Integer> toffees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getParents() {
        return parents;
    }

    public void setParents(Map<String, String> parents) {
        this.parents = parents;
    }

    public Set<Integer> getToffees() {
        return toffees;
    }

    public void setToffees(Set<Integer> toffees) {
        this.toffees = toffees;
    }

    public void displayInfo(){
        System.out.println("Student name : "+this.name);
        System.out.println("Printing the contents of map- parents");
        for (Map.Entry<String, String> entry : parents.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("Printing the contents of set- toffess");
        System.out.println(toffees);

    }

}
