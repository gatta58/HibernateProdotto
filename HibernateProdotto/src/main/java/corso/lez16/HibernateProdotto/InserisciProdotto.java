package corso.lez16.HibernateProdotto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import corso.lez16.HibernateProdotto.models.Prodotto;

public class InserisciProdotto {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("/resources/hibernate_prodotto.cfg.xml")
				.addAnnotatedClass(Prodotto.class)
				.buildSessionFactory();
		
		Session sessione = factory.getCurrentSession();
		
		try {
			Prodotto kinderBrioss = new Prodotto("KB123456", "Kinder Brioss", 2.69f);
			Prodotto kinderFAA = new Prodotto("KB123457", "Kinder Fetta al Latte", 2.69f);
			Prodotto KinderDelice = new Prodotto("KB123458", "Kinder Delice", 2.69f);
			
			sessione.beginTransaction();
			
			sessione.save(kinderBrioss);
			sessione.save(kinderFAA);
			sessione.save(KinderDelice);
			
			sessione.getTransaction().commit();
			
			System.out.println(kinderBrioss.toString());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
		
		
	}

}
