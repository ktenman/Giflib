package eu.estimol.giflib.controller;

import eu.estimol.giflib.model.Gif;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Konstantin on 12.03.2016.
 */
public class GifsFromDatabase {
    private static SessionFactory factory;
    public GifsFromDatabase(){
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        String hql = "FROM Gif";
        Query query = session.createQuery(hql);
        List results = query.list();
        System.out.println("size: "+results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i).toString());
        }
        /*Session session = vabrik.openSession();
        ArrayList<Gif> gifsAndmebaasist = session.get(Gif.class)
        vabrik.close();
        for(Gif g:gifsAndmebaasist){
            System.out.println(g.toString());
        }
        */
        factory.close();
    }



    public static void main(String[] args) {
        new GifsFromDatabase();
    }
}
