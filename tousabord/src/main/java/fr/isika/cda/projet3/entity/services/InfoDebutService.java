package fr.isika.cda.projet3.entity.services;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda.projet3.entity.utilisateurs.Adresse;


@Entity
public class InfoDebutService {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Adresse lieuDeDepart = new Adresse();
	

	private Date dateDeDepart;
	
	
	private Date heureDeDepart;
	

	public Adresse getLieuDeDepart() {
		return lieuDeDepart;
	}
	public void setLieuDeDepart(Adresse lieuDeDepart) {
		this.lieuDeDepart = lieuDeDepart;
	}
	public Date getDateDeDepart() {
		return dateDeDepart;
	}
	public void setDateDeDepart(Date dateDeDepart) {
		this.dateDeDepart = dateDeDepart;
	}
	public Date getHeureDeDepart() {
		return heureDeDepart;
	}
	public void setHeureDeDepart(Date heureDeDepart) {
		this.heureDeDepart = heureDeDepart;
	}
	public Long getId() {
		return Id;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dateDeDepart, heureDeDepart, lieuDeDepart);
	}
	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		InfoDebutService other = (InfoDebutService) obj;
		return Objects.equals(dateDeDepart, other.dateDeDepart) && Objects.equals(heureDeDepart, other.heureDeDepart)
				&& Objects.equals(lieuDeDepart, other.lieuDeDepart);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoDebutService [Id=");
		builder.append(Id);
		builder.append(", lieuDeDepart=");
		builder.append(lieuDeDepart);
		builder.append(", dateDeDepart=");
		builder.append(dateDeDepart);
		builder.append(", heureDeDepart=");
		builder.append(heureDeDepart);
		builder.append("]");
		return builder.toString();
	}

	
}
