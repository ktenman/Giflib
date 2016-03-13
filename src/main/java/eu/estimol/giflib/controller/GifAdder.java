package eu.estimol.giflib.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
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
		System.out.println("Working Directory = " +
				System.getProperty("user.dir"));
		File file = new File("src/main/resources/static/gifs/android-explosion.gif");
		byte[] imageData = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(imageData);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gif gif = new Gif();
		gif.setName("compiler-bot");
		gif.setDateUploaded(LocalDate.of(2016,2,13));
		gif.setUsername("Konstantin Tenman");
		gif.setFavorite(true);
		gif.setContent(imageData);
		session.save(gif);
		t1.commit();
		vabrik.close();
	}
//	public static void main(String[] args){
//		new GifAdder();
//	}
}