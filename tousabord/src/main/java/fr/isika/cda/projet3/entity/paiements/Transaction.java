package fr.isika.cda.projet3.entity.paiements;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.projet3.entity.utilisateurs.Consommateur;
import fr.isika.cda.projet3.entity.utilisateurs.Contributeur;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	TypeTransaction typeTransaction;
	
	private LocalDate dateTransaction;
	
	@Column(precision=12, scale=2)
	private BigDecimal montant;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Consommateur consommateur;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Contributeur contributeur;
	
	@Lob
	@OneToOne(cascade = CascadeType.ALL)
	private Facture facture;
	
	public Transaction() {
		dateTransaction = LocalDate.now();
	}
	
	public Facture getFacture() {
		return facture;
	}
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	public Consommateur getConsommateur() {
		return consommateur;
	}
	
	public void setConsommateur(Consommateur consommateur) {
		this.consommateur = consommateur;
	}
	
	public Contributeur getContributeur() {
		return contributeur;
	}
	
	public void setContributeur(Contributeur contributeur) {
		this.contributeur = contributeur;
	}

	public TypeTransaction getTypeTransaction() {
		return typeTransaction;
	}

	public void setTypeTransaction(TypeTransaction typeTransaction) {
		this.typeTransaction = typeTransaction;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}
	
	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [id=");
		builder.append(id);
		builder.append(", typeTransaction=");
		builder.append(typeTransaction);
		builder.append(", dateTransaction=");
		builder.append(dateTransaction);
		builder.append(", montant=");
		builder.append(montant);
		builder.append("]");
		return builder.toString();
	}

}
