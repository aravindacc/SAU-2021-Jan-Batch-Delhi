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
        a.setAid(2);
        a.setAname("mkmmkn");
        a.setColor("black");
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sesFac = con.buildSessionFactory();
        Session session = sesFac.openSession();
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
    }

    static void getData(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sesFac = con.buildSessionFactory();
        Session session = sesFac.openSession();
        Transaction tx = session.beginTransaction();
        a = (Alien) session.get(Alien.class, 1);
        tx.commit();
        System.out.println(a);
    }

    static void firstLevelCacheWorking(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sesFac = con.buildSessionFactory();
        Session session1 = sesFac.openSession();
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
        SessionFactory sesFac = con.buildSessionFactory();
        Session session1 = sesFac.openSession();
        Transaction tx1 = session1.beginTransaction();
        a = (Alien) session1.get(Alien.class, 1);
        System.out.println(a);
        tx1.commit();
        Session session2 = sesFac.openSession();
        Transaction tx2 = session1.beginTransaction();
        a = (Alien) session2.get(Alien.class, 1);
        System.out.println(a);
        tx2.commit();

    }

    static void queryWise(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sesFac = con.buildSessionFactory();
        Session session1 = sesFac.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = 1");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();
        Session session2 = sesFac.openSession();
        Transaction tx2 = session1.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid = 1");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        tx2.commit();

    }
    
    public static void Query(){
        Alien alien;
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sesFac = con.buildSessionFactory();
        Session session = sesFac.openSession();
        Transaction tx2 = session.beginTransaction();

        Query query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien)query.uniqueResult();
        
        System.out.println("Query 1 Result : " + alien);

        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        
        System.out.println("Query 2 Result : " + alien);

        query = session.createQuery("from Alien where aname = 'Dishant'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        
        System.out.println("Query 3 Result : " + alien);

        query = session.createQuery("from Alien where aname = 'Rahul'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 4 Result : " + alien);

        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 5 Result : " + alien);

        tx2.commit();
    }

    public static void main(String [] args){
        saveData();
        getData();
        firstLevelCacheWorking();
        secondLevelCache();
        queryWise();
        // 5 queries
        Query();
    }
}
