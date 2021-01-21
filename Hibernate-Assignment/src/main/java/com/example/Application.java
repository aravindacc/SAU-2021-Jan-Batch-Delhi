package com.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//import org.hibernate.Query;
public class Application {
    public static void main(String [] args){
    	System.out.println("Hello");
    	/*Shubham sh=new Shubham();
    	Alien a=new Alien();
    	a.setAid(1);
    	a.setAname("Name131");
    	a.setColor("Red131");
    	Alien b=new Alien();
    	a.setAid(2);
    	a.setAname("Name142");
    	a.setColor("Red142");
    	List<Alien> l =new ArrayList<Alien>();
    	l.add(a);
    	l.add(b);
    	//sh.setal(l);
    	sh.setclg("DU131");
    	sh.setfood("Cake131");
    	sh.setid(1);
    	
    	Configuration con  = new Configuration().configure().addAnnotatedClass(Shubham.class).addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
       session1.get(Alien.class, 2);
    	System.out.println(sh);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        session2.get(Alien.class, 2);
        tx2.commit();
        */
    	firstLevelCache();
    	secondLevelCache1();
    	secondLevelCache2();
    	HQLAndCaching();
    }

@org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_ONLY)
    static void secondLevelCache1(){
        Alien a = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        a = (Alien) session1.get(Alien.class, 1);
        System.out.println(a);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        a = (Alien) session2.get(Alien.class, 1);
        System.out.println(a);
        tx2.commit();

    }
static void secondLevelCache2(){ Alien a = new Alien();
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

}

static void firstLevelCache(){
    Alien a = new Alien();
    Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
    SessionFactory sf = con.buildSessionFactory();
    Session session1 = sf.openSession();
    Transaction tx1 = session1.beginTransaction();
    a = (Alien) session1.get(Alien.class, 1);
    System.out.println(a);
    a = (Alien) session1.get(Alien.class, 2);
    System.out.println(a);
    tx1.commit();

}
static void HQLAndCaching() {
	 Alien a = new Alien();
	    Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
	    SessionFactory sf = con.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
	    Query query = session.createQuery("from Alien where aid= :id");
		query.setParameter("id", 3);
		Alien emp = (Alien) query.uniqueResult();
		System.out.println(a);
		Query query1 = session.createQuery("from Alien where aid= :id");
		query1.setParameter("id", 3);
		Alien a1 = (Alien) query1.uniqueResult();
		System.out.println(a1);
	    tx.commit();
}
}
