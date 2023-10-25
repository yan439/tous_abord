package fr.isika.cda.projet3.entity.paiements;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class BonDAchat extends MoyenDePaiement {

	@Column(precision = 12, scale = 2)
	private BigDecimal valeur;

	@Temporal(TemporalType.DATE)
	private Date dateDeValidite;

	public BonDAchat() {

	}

	public BigDecimal getValeur() {
		return valeur;
	}

	public void setValeur(BigDecimal valeur) {
		this.valeur = valeur;
	}

	public Date getDateDeValidite() {
		return dateDeValidite;
	}

	public void setDateDeValidite(Date dateDeValidite) {
		this.dateDeValidite = dateDeValidite;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BonDAchat [valeur=");
		builder.append(valeur);
		builder.append(", dateDeValidite=");
		builder.append(dateDeValidite);
		builder.append("]");
		return builder.toString();
	}

}
