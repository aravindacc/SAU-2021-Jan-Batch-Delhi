package com.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dishant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
//    @OneToOne
//    private Alien alien;

    @OneToMany
    private List<Alien> alien=new ArrayList<Alien>();

    String favColor,favFood;
    //@Transient
    int age;

    public Dishant() {
    }

    public Dishant(int age, String favColor, String favFood,List<Alien> alien) {
        this.favColor = favColor;
        this.favFood = favFood;
        this.age=age;
        this.alien=alien;
    }

    public Dishant(int age, String favColor, String favFood, Alien alien) {
        this.favColor = favColor;
        this.favFood = favFood;
        this.age=age;
        //this.alien=alien;
    }

    public String getFavColor() {
        return favColor;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
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
        return "Dishant{" +
                "id=" + id +
                ", favColor='" + favColor + '\'' +
                ", favFood='" + favFood + '\'' +
                ", age=" + age +
                '}';
    }
}
