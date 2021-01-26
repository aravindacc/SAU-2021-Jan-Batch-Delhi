package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String [] args){
        
        
        //Question No 1
        Alien alien1=new Alien();
        alien1.setid(10);
        alien1.setAname("RedAlien");
        a.setColor("black");
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(alien1);
        tx.commit();


        //Question No 2
        Session session1=sf.openSession();
        Transaction tx1=session1.beginTransaction();
        alien1 =(Alien) session1.get(Alien.class,1);
        System.out.println(alien1);
        tx1.commit();



        //Question No 3
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        Alien alien2 = (Alien)session2.get(Alien.class, 10);
        Alien alien3 = (Alien)session2.get(Alien.class, 10);
        System.out.println(alien2);
        System.out.println(alien3);
        tx2.commit();


        //Question No 4
        Session session3 = sf.openSession();
        Transaction tx3 = session3.beginTransaction();
        alien1 = (Alien)session3.get(Alien.class, 10);
        System.out.println(alien1);
        tx3.commit();
        Session session4 = sf.openSession();
        Transaction tx4 = session4.beginTransaction();
        alien1 = (Alien)session4.get(Alien.class, 10);
        System.out.println(alien1);
        tx4.commit();



        //Question No 5
        Session session5 = sf.openSession();
        Transaction tx5 = session5.beginTransaction();
        Query q1=session5.createQuery("from Alien where aid=44");
        Alien a =(Alien)q1.uniqueResult();
        System.out.println(a);
        tx5.commit();


        //Question No 6
        Session session6=sf.openSession();
        Transaction tx6=session6.beginTransaction();

        Query query = session6.createQuery("from Alien where aid = 10");
        query.setCacheable(true);
        Alien alien = (Alien) query.uniqueResult();
        System.out.println(alien);

        query = session6.createQuery("from Alien where aid = 10");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println(alien);

        query = session6.createQuery("from Alien where aname = 'RedAlien'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println(alien);

        query = session6.createQuery("from Alien where aname = 'RedAlien'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println(alien);

        query = session6.createQuery("from Alien where aid = 10");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println(alien);

        tx6.commit();


    }
}
