package fr.isika.cda.projet3.entity.services;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Colis {

	@Id
	@GeneratedValue
	private Long id;

	@Column(precision = 12, scale = 2)
	private BigDecimal poids;

	@Enumerated(EnumType.STRING)
	private TailleColis taille;

	@Lob 
	@Basic(fetch=FetchType.LAZY) 
	private String description;
	
	public Colis() {
	}





	public BigDecimal getPoids() {
		return poids;
	}

	public void setPoids(BigDecimal poids) {
		this.poids = poids;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	public TailleColis getTaille() {
		return taille;
	}
	
	public void setTaille(TailleColis taille) {
		this.taille = taille;
	}





	@Override
	public int hashCode() {
		return Objects.hash(description, poids, taille);
	}





	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Colis other = (Colis) obj;
		return Objects.equals(description, other.description) && Objects.equals(poids, other.poids)
				&& taille.equals(other.taille);
	}





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Colis [poids=");
		builder.append(poids);
		builder.append(", taille=");
		builder.append(taille);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}


	
	

}
