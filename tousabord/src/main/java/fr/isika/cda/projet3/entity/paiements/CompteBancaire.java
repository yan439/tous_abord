package fr.isika.cda.projet3.entity.paiements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CompteBancaire extends MoyenDePaiement {

	@Column(length = 50)
	private String iban;

	private String nomDeLaBanque;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getNomDeLaBanque() {
		return nomDeLaBanque;
	}

	public void setNomDeLaBanque(String nomDeLaBanque) {
		this.nomDeLaBanque = nomDeLaBanque;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompteBancaire [id=");
		builder.append(id);
		builder.append(", iban=");
		builder.append(iban);
		builder.append(", nomDeLaBanque=");
		builder.append(nomDeLaBanque);
		builder.append("]");
		return builder.toString();
	}

}
