package fr.isika.cda.projet3.entity.utilisateurs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TypeUtilisateur typeUtilisateur;
 
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Compte compte = new Compte();
	
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private InfosPersonnelles infoPersonnelle = new InfosPersonnelles();
	
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private Adresse adresse = new Adresse();
	
	@OneToOne (cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	private Contact contact= new Contact();
	
	

	@OneToMany
	private List<Avis> avis = new ArrayList<>();
	
	@OneToMany
	private List<Vehicule> vehicules = new ArrayList<>();
	
	@OneToMany
	private List<Don> dons = new ArrayList<>();

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Service> services = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Reservation> reservations = new ArrayList<>();

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Message> messages = new ArrayList<>();

	
	public Utilisateur() {
		
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public List<Service> getServices() {
		return services;
	}
	
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeUtilisateur getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public InfosPersonnelles getInfoPersonnelle() {
		return infoPersonnelle;
	}

	public void setInfoPersonnelle(InfosPersonnelles infoPersonnelle) {
		this.infoPersonnelle = infoPersonnelle;
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


	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}	

	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [getReservations()=");
		builder.append(getReservations());
		builder.append(", getServices()=");
		builder.append(getServices());
		builder.append(", getVehicules()=");
		builder.append(getVehicules());
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getTypeUtilisateur()=");
		builder.append(getTypeUtilisateur());
		builder.append(", getCompte()=");
		builder.append(getCompte());
		builder.append(", getInfoPersonnelle()=");
		builder.append(getInfoPersonnelle());
		builder.append(", getAdresse()=");
		builder.append(getAdresse());
		builder.append(", getAvis()=");
		builder.append(getAvis());
		builder.append(", getDons()=");
		builder.append(getDons());
		builder.append(", getContact()=");
		builder.append(getContact());
		builder.append("]");
		return builder.toString();
	}

	public void addVehicule(Vehicule v) {
		this.vehicules.add(v);
	}

	public void addService(Service service) {
		this.services.add(service);
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}

	public void addDon(Don don) {
		this.dons.add(don);
	}

	public void removeService(Long id2) {
		Iterator<Service> iterator = this.services.iterator();
		while(iterator.hasNext()) {
			Service service = iterator.next();
			if(service.getId().equals(id2)) {
				iterator.remove();
				break;
			}
		}
	}
	
}
