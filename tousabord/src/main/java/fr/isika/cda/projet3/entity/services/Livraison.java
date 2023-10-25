package fr.isika.cda.projet3.entity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Livraison extends Service {
	
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	private String description;

	@OneToMany(cascade = {CascadeType.ALL})
	private List<Colis> colis = new ArrayList<Colis>();
	
	public Livraison() {
	}
	
	public List<Colis> getColis() {
		return colis;
	}
	
	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(colis);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (!super.equals(obj))
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Livraison other = (Livraison) obj;
		return Objects.equals(colis, other.colis);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livraison [id=");
		builder.append(id);
		builder.append(", nomduService=");
		builder.append(nomduService);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", etatService=");
		builder.append(etatService);
		builder.append("]");
		return builder.toString();
	}

	public void ajouterColis(Colis c) {
		this.colis.add(c);	
	}

	
}
