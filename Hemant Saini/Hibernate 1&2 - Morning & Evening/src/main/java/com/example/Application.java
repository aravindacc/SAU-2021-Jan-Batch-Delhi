package com.example;

import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String [] args){
        System.out.println("Hello Hibernate");

        Hemant hemant = new Hemant("Yellow", "Samosa", 25);
        Alien alien = new Alien(1, "Hemant Alien", "red");
        //hemant.setAlien(alien);

        Alien alien2 = new Alien(2, "Hemant Alien", "red");

        List<Alien> list = new ArrayList<>();
        list.add(alien);
        list.add(alien2);
        hemant.setListAlien(list);

        Configuration con  = new Configuration().configure().addAnnotatedClass(Hemant.class).addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        /************************** To Save an Item ******************************/
        //session.save(alien);
        //session.save(alien2);
        //session.save(hemant);

        /********************** To get an item using get() *********************/
        Hemant getObject = (Hemant) session.get(Hemant.class, 1);
        Alien getObjectAlien = (Alien) session.get(Alien.class, 1);
        Alien getObject2 = (Alien) session.get(Alien.class, 1);
        Hemant getObject3 = (Hemant) session.get(Hemant.class, 1);

        /********************* Using createQuery() (HQL) ***********************/
        Query q1 = session.createQuery("from Hemant where hemantId = 1");
        q1.setCacheable(true);
        Hemant getObject5 = (Hemant) q1.uniqueResult();
        System.out.println(getObject5.toString());
        tx.commit();

        /************** Using different session to show caching **************/
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        Query q2 = session2.createQuery("from Hemant where hemantId = 1");
        q2.setCacheable(true);
        Hemant getObject6 = (Hemant) q2.uniqueResult();
        System.out.println(getObject6.toString());
        tx2.commit();
    }
}
