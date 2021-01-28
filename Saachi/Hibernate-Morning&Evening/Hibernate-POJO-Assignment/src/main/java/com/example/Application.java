package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class Application {
    static void saveData(int id, String name, String food){
        Alien alien = new Alien();
        alien.setId(id);
        alien.setName(name);
        alien.setFood(food);
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
    }

    static void getDataById(int id){
        Alien alien = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        alien = (Alien) session.get(Alien.class, id);
        tx.commit();
        System.out.println(alien);
    }

    static void firstLevelCacheQuery(int id){
        Alien alien = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx = session1.beginTransaction();
        alien = (Alien) session1.get(Alien.class, id);
        System.out.println(alien);
        alien = (Alien) session1.get(Alien.class, id);
        System.out.println(alien);
        tx.commit();
    }


    static void secondLevelCacheQuery(int id){
        Alien alien = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        alien = (Alien) session1.get(Alien.class, id);
        System.out.println(alien);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        alien = (Alien) session2.get(Alien.class, id);
        System.out.println(alien);
        tx2.commit();

    }

    static void cacheableHQL_query(){
        Alien alien = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where id = 101",Alien.class);
        q1.setCacheable(true);
        alien = (Alien) q1.uniqueResult();
        System.out.println(alien);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        Query q2 = session2.createQuery("from Alien where id = 101", Alien.class);
        q2.setCacheable(true);
        alien = (Alien) q2.uniqueResult();
        System.out.println(alien);
        tx2.commit();

    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Alien Id:");
        int id=input.nextInt();
        System.out.println("Enter the Alien Name:");
        input.nextLine();
        String name=input.nextLine();
        System.out.println("Enter the Alien Food :");
        String food=input.nextLine();
        saveData(id, name, food);

        System.out.println("Enter the Alien Id to get the corresponding data:");
        int alien_id=input.nextInt();
        getDataById(alien_id);

        firstLevelCacheQuery(alien_id);
        secondLevelCacheQuery(alien_id);
        cacheableHQL_query();
    }
}
