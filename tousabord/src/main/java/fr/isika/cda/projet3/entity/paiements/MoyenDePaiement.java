package fr.isika.cda.projet3.entity.paiements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MoyenDePaiement {

	@Id
	@GeneratedValue
	protected Long id;

	public Long getId() {
		return id;
	}

}
