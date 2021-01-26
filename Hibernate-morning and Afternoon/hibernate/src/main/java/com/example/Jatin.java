package com.example;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.Cache;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Jatin {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int aadharno;

//    @Transient
    private int age;
    private String favFood;

//    @OneToOne
//    public Alien alien;

    @OneToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    List<Alien> alienList=new ArrayList<>();

//    public Alien getAlien() {
//        return alien;
//    }
//
//    public  void setAlien(Alien alien) {
//        this.alien = alien;
//    }

    public List<Alien> getAlienList() {
        return alienList;
    }

    public void setAlienList(List<Alien> alienList) {
        this.alienList = alienList;
    }

    public Jatin(){}

    public Jatin(int aadharno) {
        this.aadharno = aadharno;
    }

    public int getAadharno() {
        return aadharno;
    }

    public void setAadharno(int aadharno) {
        this.aadharno = aadharno;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }



    public int getAge() {
        return age;
    }

    public String getFavFood() {
        return favFood;
    }


    @Override
    public String toString() {
        return "Jatin{" +
                "aadharno=" + aadharno +
                ", age=" + age +
                ", favFood=" + favFood +
                ",AlienList " + alienList.toString()+
                '}';
    }
}
