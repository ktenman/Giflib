package eu.estimol.giflib.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import eu.estimol.giflib.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class GifAdder {
	public GifAdder() {
		Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		SessionFactory vabrik = new Configuration().configure().buildSessionFactory();
		Session session = vabrik.openSession();
		Transaction t1 = session.beginTransaction();
		Gif gif = new Gif("compiler-bot", LocalDate.of(2016,2,13),"Konstantin Tenman", true);
		session.save(gif);
		gif = new Gif("compiler-bot", LocalDate.of(2017,2,13),"Ivanov", true);
		session.save(gif);
		t1.commit();
		vabrik.close();
	}
	public static void main(String[] args){
		new GifAdder();
	}
}