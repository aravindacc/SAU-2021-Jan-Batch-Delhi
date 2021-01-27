package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Application {

    static void saveData(){
        Alien a = new Alien();
        Alien b=new Alien();
        b.setAid(1);
        b.setAname("Rakesh");
        b.setColor("blue");
        a.setAid(2);
        a.setAname("Niket");
        a.setColor("red");
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        session.save(b);
        tx.commit();



    }

    static void getData(int id){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        a = (Alien) session.get(Alien.class, id);
        tx.commit();
        System.out.println(a);
    }

    static void firstLevelCache(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx = session1.beginTransaction();
        a = (Alien) session1.get(Alien.class, 1);
        System.out.println(a);
        a = (Alien) session1.get(Alien.class, 1);
        System.out.println(a);
        tx.commit();
    }


    static void secondLevelCache(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        a = (Alien) session1.get(Alien.class, 1);
        System.out.println("Session 1 Query");

        System.out.println(a);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        a = (Alien) session2.get(Alien.class, 1);
        System.out.println("Session 2 Query");
        System.out.println(a);
        tx2.commit();

    }
    static void hql(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = 2");
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();

    }

    static void queryWise(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = 1");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid = 1");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        tx2.commit();

    }

    public static void main(String [] args){
        //saveData();
        getData(2);
        firstLevelCache();
        secondLevelCache();
        hql();
        queryWise();
    }
}
