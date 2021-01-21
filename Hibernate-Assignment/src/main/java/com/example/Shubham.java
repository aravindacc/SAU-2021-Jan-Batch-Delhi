package com.example;
import java.util.*;
import javax.persistence.*;

@Entity
public class Shubham {
    @Id
    private int id;
    private String clg;
    private String food;
    
    //private List<Alien> al=new ArrayList<Alien>();
    public int getid() {
        return id;
    }

    public void setid(int aid) {
        this.id = aid;
    }
    /*public List<Alien> getal() {
        return al;
    }

    public void setal(List<Alien> ai) {
        al = ai;
    }
*/
    public Shubham() {}
    public String getclg() {
        return clg;
    }

    public void setclg(String c) {
        this.clg = c;
    }

    public String getfood() {
        return food;
    }

    public void setfood(String f) {
        this.food = f;
    }
}
