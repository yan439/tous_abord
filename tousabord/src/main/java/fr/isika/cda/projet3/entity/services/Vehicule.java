package fr.isika.cda.projet3.entity.services;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Entity
public class Vehicule {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String marque; // Possibilité d'utiliser les enum
	private String modele; // Possibilité d'utiliser les enum
	private byte nombreDePlaces;
	private byte nombreDePortes;
	private String motorisation;
	private String boiteDeVitesse;
	private int kilometrage;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Justificatif justificatif;
	
	
	
	public Vehicule() {
	}

	


	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public byte getNombreDePlaces() {
		return nombreDePlaces;
	}

	public void setNombreDePlaces(byte nombreDePlaces) {
		this.nombreDePlaces = nombreDePlaces;
	}

	public byte getNombreDePortes() {
		return nombreDePortes;
	}

	public void setNombreDePortes(byte nombreDePortes) {
		this.nombreDePortes = nombreDePortes;
	}

	public String getMotorisation() {
		return motorisation;
	}

	public void setMotorisation(String motorisation) {
		this.motorisation = motorisation;
	}

	public String getBoiteDeVitesse() {
		return boiteDeVitesse;
	}

	public void setBoiteDeVitesse(String boiteDeVitesse) {
		this.boiteDeVitesse = boiteDeVitesse;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Justificatif getJustificatif() {
		return justificatif;
	}

	public void setJustificatif(Justificatif justificatif) {
		this.justificatif = justificatif;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boiteDeVitesse, justificatif, kilometrage, marque, modele, motorisation, nombreDePlaces,
				nombreDePortes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Vehicule other = (Vehicule) obj;
		return Objects.equals(boiteDeVitesse, other.boiteDeVitesse) && Objects.equals(justificatif, other.justificatif)
				&& kilometrage == other.kilometrage && Objects.equals(marque, other.marque)
				&& Objects.equals(modele, other.modele) && Objects.equals(motorisation, other.motorisation)
				&& nombreDePlaces == other.nombreDePlaces && nombreDePortes == other.nombreDePortes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicule [id=");
		builder.append(id);
		builder.append(", marque=");
		builder.append(marque);
		builder.append(", modele=");
		builder.append(modele);
		builder.append(", nombreDePlaces=");
		builder.append(nombreDePlaces);
		builder.append(", nombreDePortes=");
		builder.append(nombreDePortes);
		builder.append(", motorisation=");
		builder.append(motorisation);
		builder.append(", boiteDeVitesse=");
		builder.append(boiteDeVitesse);
		builder.append(", kilometrage=");
		builder.append(kilometrage);
		builder.append(", justificatif=");
		builder.append(justificatif);
		builder.append("]");
		return builder.toString();
	}
	
	

	

}
