import antlr.actions.cpp.ActionLexer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {

        // create configs
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        // saving alien object to db
        Alien alien = new Alien("Xyz", "Abc");
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();

        // retrieve object form db
        tx = session.beginTransaction();
        alien = session.get(Alien.class, 1);
        System.out.println(alien);
        tx.commit();

        // one session with 2 queries
        alien = new Alien("Dog", "black");
        tx = session.beginTransaction();
        session.save(alien);
        tx.commit();
        tx = session.beginTransaction();
        alien = session.get(Alien.class, 2);
        System.out.println(alien);
        tx.commit();
        tx = session.beginTransaction();
        alien = session.get(Alien.class, 2);
        System.out.println(alien);
        tx.commit();

        // two session with second level cache
        Session session2 = sf.openSession();
        alien = new Alien("Cat", "green");
        tx = session.beginTransaction();
        session.save(alien);
        tx.commit();

        tx = session.beginTransaction();
        alien = session.get(Alien.class, 3);
        System.out.println(alien);
        tx.commit();
        tx = session2.beginTransaction();
        alien = session2.get(Alien.class, 3);
        System.out.println(alien);
        tx.commit();


        // using HQL queries
        Query<Alien> query = session.createQuery("from Alien");
        List<Alien> a = query.getResultList();
        for (Alien al: a) {
            System.out.println(al);
        }

        // cacheable HQL query
        tx = session.beginTransaction();
        Query q1 = session.createQuery("from Alien where id = 1",Alien.class);
        q1.setCacheable(true);
        alien = (Alien) q1.uniqueResult();
        System.out.println(alien);
        tx.commit();
        tx = session.beginTransaction();
        Query q2 = session2.createQuery("from Alien where id = 1", Alien.class);
        q2.setCacheable(true);
        alien = (Alien) q2.uniqueResult();
        System.out.println(alien);
        tx.commit();

    }
}
