package com.example;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Hemant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int hemantID;

    String favColor;
    String favFood;

    //@Transient
    @ColumnDefault("-1")
    int age;

    //@OneToOne
    //private Alien alien;

    //@Embeddable
    //@Cacheable
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany(fetch = FetchType.EAGER)
    List<Alien> listAlien = new ArrayList<>();

    public List<Alien> getListAlien() {
        return listAlien;
    }

    public void setListAlien(List<Alien> listAlien) {
        this.listAlien = listAlien;
    }

    public Hemant(){}

    public Hemant(String favColor, String favFood) {
        this.favColor = favColor;
        this.favFood = favFood;
    }

    public Hemant(String favColor, String favFood, int age) {
        this.favColor = favColor;
        this.favFood = favFood;
        this.age = age;
    }

    public Hemant(String favColor, String favFood, int age, List<Alien> listAlien) {
        this.favColor = favColor;
        this.favFood = favFood;
        this.age = age;
        this.listAlien = listAlien;
    }

    public int getHemantID() {
        return hemantID;
    }

    public void setHemantID(int hemantID) {
        this.hemantID = hemantID;
    }

    public String getFavColor() {
        return favColor;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hemant{" +
                "hemantID=" + hemantID +
                ", favColor='" + favColor + '\'' +
                ", favFood='" + favFood + '\'' +
                ", age=" + age +
                ", listAlien=" + listAlien +
                '}';
    }
}
