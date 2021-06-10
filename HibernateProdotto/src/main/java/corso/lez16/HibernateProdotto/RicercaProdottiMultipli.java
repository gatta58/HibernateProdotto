package corso.lez16.HibernateProdotto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import corso.lez16.HibernateProdotto.models.Prodotto;

public class RicercaProdottiMultipli {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("/resources/hibernate_prodotto.cfg.xml")
				.addAnnotatedClass(Prodotto.class)
				.buildSessionFactory();
		
		Session sessione = factory.getCurrentSession();
		
		try {
			
			sessione.beginTransaction();

//			List<Prodotto> elenco = sessione.createQuery("FROM Prodotto").list();		
  			List<Prodotto> elenco = sessione.createQuery("FROM Prodotto WHERE nome = 'Kinder Brioss'").list();		
			
			for(int i=0; i<elenco.size(); i++) {
				Prodotto temp = elenco.get(i);
				System.out.println(temp.toString());
			}
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		
	}

}