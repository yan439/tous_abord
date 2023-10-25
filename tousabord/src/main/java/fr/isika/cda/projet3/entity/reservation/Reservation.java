package fr.isika.cda.projet3.entity.reservation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Utilisateur utilisateur;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Service service;
	
	@Temporal(TemporalType.DATE)
	private Date dateReservation;
	
	@Enumerated(EnumType.STRING)
	private EtatReservation etatReservation;
	
	private int nbreDePlacesReservees;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal totalPayer;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal commission1;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal commission2;
	




	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public EtatReservation getEtatReservation() {
		return etatReservation;
	}

	public void setEtatReservation(EtatReservation etatReservation) {
		this.etatReservation = etatReservation;
	}

	public int getNbreDePlacesReservees() {
		return nbreDePlacesReservees;
	}

	public void setNbreDePlacesReservees(int nbreDePlacesReservees) {
		this.nbreDePlacesReservees = nbreDePlacesReservees;
	}

	public BigDecimal getTotalPayer() {
		return totalPayer;
	}

	public void setTotalPayer(BigDecimal totalPayer) {
		this.totalPayer = totalPayer;
	}

	public BigDecimal getCommission1() {
		return commission1;
	}

	public void setCommission1(BigDecimal commission1) {
		this.commission1 = commission1;
	}

	public BigDecimal getCommission2() {
		return commission2;
	}

	public void setCommission2(BigDecimal commission2) {
		this.commission2 = commission2;
	}

	public Long getId() {
		return id;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(commission1, commission2, dateReservation, etatReservation, nbreDePlacesReservees,
				totalPayer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(commission1, other.commission1) && Objects.equals(commission2, other.commission2)
				&& Objects.equals(dateReservation, other.dateReservation) && etatReservation.equals(other.etatReservation)
				&& nbreDePlacesReservees == other.nbreDePlacesReservees && Objects.equals(totalPayer, other.totalPayer);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [getDateReservation()=");
		builder.append(getDateReservation());
		builder.append(", getEtatReservation()=");
		builder.append(getEtatReservation());
		builder.append(", getNbreDePlacesReservees()=");
		builder.append(getNbreDePlacesReservees());
		builder.append(", getTotalPayer()=");
		builder.append(getTotalPayer());
		builder.append(", getCommission1()=");
		builder.append(getCommission1());
		builder.append(", getCommission2()=");
		builder.append(getCommission2());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getUtilisateur()=");
		builder.append(getUtilisateur());
		builder.append(", getService()=");
		builder.append(getService());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
