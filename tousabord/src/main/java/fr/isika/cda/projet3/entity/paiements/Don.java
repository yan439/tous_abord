package fr.isika.cda.projet3.entity.paiements;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Entity
public class Don {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateDuDon;

	@Column(precision = 12, scale = 2)
	private BigDecimal montant;

	private String nomDuDonateur;

	private String prenomDuDonateur;
	
	public Don() {
		
	}
	
	public Date getDateDuDon() {
		return dateDuDon;
	}

	public void setDateDuDon(Date dateDuDon) {
		this.dateDuDon = dateDuDon;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String getNomDuDonateur() {
		return nomDuDonateur;
	}

	public void setNomDuDonateur(String nomDuDonateur) {
		this.nomDuDonateur = nomDuDonateur;
	}

	public String getPrenomDuDonateur() {
		return prenomDuDonateur;
	}

	public void setPrenomDuDonateur(String prenomDuDonateur) {
		this.prenomDuDonateur = prenomDuDonateur;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Don [id=");
		builder.append(id);
		builder.append(", dateDuDon=");
		builder.append(dateDuDon);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", nomDuDonateur=");
		builder.append(nomDuDonateur);
		builder.append(", prenomDuDonateur=");
		builder.append(prenomDuDonateur);
		builder.append("]");
		return builder.toString();
	}

}
