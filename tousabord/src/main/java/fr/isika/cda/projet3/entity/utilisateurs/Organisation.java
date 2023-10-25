package fr.isika.cda.projet3.entity.utilisateurs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;

@Entity
public class Organisation {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String raisonSociale;

	private String imagePath;
	
	private long numeroSiren;
	
	private long numeroRna;
	
	@Enumerated(EnumType.STRING)
	private Statut statut;
	

	@OneToOne (cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	private Contact contact= new Contact();

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Compte compte = new Compte();

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Adresse adresse = new Adresse();
	
	

	@OneToMany(fetch = FetchType.EAGER)
	private List<Avis> avis = new ArrayList<>();
	
	@OneToMany
	private List<Vehicule> vehicules = new ArrayList<>();
	
	@OneToMany
	private List<Don> dons = new ArrayList<>();

	@OneToMany
	private List<Service> services = new ArrayList<>();
	
	
	public Organisation() {
		super();
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public long getNumeroSiren() {
		return numeroSiren;
	}

	public void setNumeroSiren(long numeroSiren) {
		this.numeroSiren = numeroSiren;
	}

	public long getNumeroRna() {
		return numeroRna;
	}

	public void setNumeroRna(long numeroRna) {
		this.numeroRna = numeroRna;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
 
	
	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Organisation [id=");
		builder.append(id);
		builder.append(", raisonSociale=");
		builder.append(raisonSociale);
		builder.append(", numeroSiren=");
		builder.append(numeroSiren);
		builder.append(", numeroRna=");
		builder.append(numeroRna);
		builder.append(", statut=");
		builder.append(statut);
		builder.append(", contact=");
		builder.append(contact);
		builder.append(", compte=");
		builder.append(compte);
		builder.append(", adresse=");
		builder.append(adresse);
		builder.append("]");
		return builder.toString();
	}
	

	
}
