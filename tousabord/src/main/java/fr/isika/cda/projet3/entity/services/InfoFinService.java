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
public class InfoFinService {
	
	@Id
	@GeneratedValue
	private Long Id;
	

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Adresse lieuDArrivee = new Adresse();
	
	private Date dateDArrivee;
	
	private Date heureDArrivee;

	public Adresse getLieuDArrivee() {
		return lieuDArrivee;
	}
	public void setLieuDArrivee(Adresse lieuDArrivee) {
		this.lieuDArrivee = lieuDArrivee;
	}
	public Date getDateDArrivee() {
		return dateDArrivee;
	}
	public void setDateDArrivee(Date dateDArrivee) {
		this.dateDArrivee = dateDArrivee;
	}
	public Date getHeureDArrivee() {
		return heureDArrivee;
	}
	public void setHeureDArrivee(Date heureDArrivee) {
		this.heureDArrivee = heureDArrivee;
	}
	public Long getId() {
		return Id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dateDArrivee, heureDArrivee, lieuDArrivee);
	}
	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		InfoFinService other = (InfoFinService) obj;
		return Objects.equals(dateDArrivee, other.dateDArrivee) && Objects.equals(heureDArrivee, other.heureDArrivee)
				&& Objects.equals(lieuDArrivee, other.lieuDArrivee);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InfoFinService [Id=");
		builder.append(Id);
		builder.append(", lieuDArrivee=");
		builder.append(lieuDArrivee);
		builder.append(", dateDArrivee=");
		builder.append(dateDArrivee);
		builder.append(", heureDArrivee=");
		builder.append(heureDArrivee);
		builder.append("]");
		return builder.toString();
	}

	
}
