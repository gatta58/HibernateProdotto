package corso.lez16.HibernateProdotto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import corso.lez16.HibernateProdotto.models.Prodotto;

public class EliminaProdotto {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("/resources/hibernate_prodotto.cfg.xml")
				.addAnnotatedClass(Prodotto.class)
				.buildSessionFactory();
		
		Session sessione = factory.getCurrentSession();
		
		try {
			
			sessione.beginTransaction();
			
			int affRows = sessione.createQuery("DELETE Prodotto WHERE id = 3").executeUpdate();
			
			if(affRows > 0) {
				System.out.println("Eliminazione effettuata");
			}
			else {
				System.out.println("Errore di eliminazione");
			}
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
	}
}
