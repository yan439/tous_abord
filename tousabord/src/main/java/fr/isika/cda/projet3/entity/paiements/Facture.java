package fr.isika.cda.projet3.entity.paiements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Facture {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

}
