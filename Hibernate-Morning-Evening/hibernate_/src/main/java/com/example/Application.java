//package com.example;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class Application {
//    public static void main(String [] args){
//        System.out.println("hello hibernate");
//        Alien a = new Alien();
//        a.setAid(1);
//        a.setAname("mkmmk");
//        a.setColor("black");
//        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
//        SessionFactory sf = con.buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(a);
//        tx.commit();
//    }
//}


package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Application {

    private static final Configuration connectionVar  = new Configuration().configure().addAnnotatedClass(Alien.class);
    private static final SessionFactory sFactoryVar = connectionVar.buildSessionFactory();


    public static void main(String [] args){
//  Question 1
        Alien alien = new Alien();
        alien.setAid(1004);
        alien.setAname("Aditi");
        alien.setColor("red");
        Session session = sFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();



        //Question 2


        Session session = sFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        Alien alien = (Alien)session.get(Alien.class, 1003);
        System.out.println(alien);
        tx.commit();


//    //Question 3

        //First Level Caching
        Session session = sFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        Alien alien1 = (Alien)session.get(Alien.class, 1001);
        Alien alien2 = (Alien)session.get(Alien.class, 1003);
        System.out.println(alien1);
        System.out.println(alien2);
        tx.commit();



        //Question 4


        //Second Level Caching

        Session session1 = sFactoryVar.openSession();
        Transaction tx1 = session1.beginTransaction();
        Alien alien1 = (Alien)session1.get(Alien.class, 1001);
        System.out.println(alien1);
        tx1.commit();


        Session session2 = sFactoryVar.openSession();
        Transaction tx2 = session2.beginTransaction();
        alien1 = (Alien)session2.get(Alien.class, 1003);
        System.out.println(alien1);
        tx2.commit();



        // Question 5

        Alien a ;
        Session session1 = sFactoryVar.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = " + 1003);
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();




//    // Question 6


        Alien alien;
        Session session = sFactoryVar.openSession();
        Transaction tx2 = session.beginTransaction();
//
//        //query 1
        System.out.println("query1");
        Query query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();

        System.out.println(alien);
//
//        //query 2
        System.out.println("query2");
        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
//
        System.out.println(alien);
//
//        //query 3
        System.out.println("query3");
        query = session.createQuery("from Alien where aname = 'Adi'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();

        System.out.println(alien);
//
//        //query 4
        System.out.println("query4");
        query = session.createQuery("from Alien where aname = 'Aditi'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();

        System.out.println(alien);
//
//        //query 5
        System.out.println("query5");
        query = session.createQuery("from Alien where aid = 1003");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();

        System.out.println(alien);
////
        tx2.commit();


    }



}
