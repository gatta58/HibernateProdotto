package corso.lez16.HibernateProdotto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodotto")
public class Prodotto {

	@Id														//Dice ad Hibernate che si tratta di una Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//IDENTITY Ã¨ la strategia di generazione degli ID AUTO_INCREMENT di MySql
	@Column(name="prodottoID")
	private int id;
	
	@Column													//Evito di inserire il (name...) perchÃ© l'attributo ha lo stesso nome della colonna.
	private String codice;
	
	@Column
	private String nome;
	
	@Column
	private Float prezzo;
	
	public Prodotto() {
		
	}

	public Prodotto(String codice, String nome, Float prezzo) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
	
	

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", codice=" + codice + ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}
	
	
	
	
	
}