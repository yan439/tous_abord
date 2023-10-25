package fr.isika.cda.projet3.entity.utilisateurs;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Adresse {
	
	@Id
	@GeneratedValue
	private Long id;
	private int numero;
	private String voie;
	private String complement;
	private String codePostal;
	private String ville;
	private String pays;
	
	
	
	public Adresse() {
		super();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Long getId() {
		return id;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codePostal, complement, numero, pays, ville, voie);
	}
	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(codePostal, other.codePostal) && Objects.equals(complement, other.complement)
				&& numero == other.numero && Objects.equals(pays, other.pays) && Objects.equals(ville, other.ville)
				&& Objects.equals(voie, other.voie);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adresse [id=");
		builder.append(id);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", voie=");
		builder.append(voie);
		builder.append(", complement=");
		builder.append(complement);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", pays=");
		builder.append(pays);
		builder.append("]");
		return builder.toString();
	}
	

}
