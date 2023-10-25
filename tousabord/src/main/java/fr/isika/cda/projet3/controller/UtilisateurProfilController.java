package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Role;

import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;

@ViewScoped
@ManagedBean
public class UtilisateurProfilController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUtilisateurService utilisateurService;

	private Utilisateur utilisateur;
	private List<Service> services = new ArrayList<>();
	private List<Vehicule> vehicules = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();
	private List<Reservation> propositionsReservees = new ArrayList<>();
	private List<Don> dons = new ArrayList<>();

	public void onLoad() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long compteId = (Long) session.getAttribute("Id");
		if (compteId != null) {
			Optional<Utilisateur> optionalUser = utilisateurService.rechercheParCompteId(compteId);
			if (optionalUser.isPresent()) {
				this.utilisateur = optionalUser.get();
				Long userId = utilisateur.getId(); 
				this.services = utilisateurService.getServices(userId);
				this.reservations = utilisateurService.getReservations(userId);
				
				this.propositionsReservees = new ArrayList<Reservation>();
				for (Service serv : services) {
					this.propositionsReservees.addAll(utilisateurService.getReservationsAvecServices(serv.getId()));
					
				}

				
				
				
				// this.vehicules = utilisateurService.getVehicule(userId);
				// this.dons = utilisateurService.getDons(userId);
			} else {
				System.err.println("User with compteId : " + compteId + " not found");
			}
		} else {
			System.err.println("Parameter : Id (compte) not found : " + compteId);
		}
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public List<Reservation> getPropositionsReservees() {
		return propositionsReservees;
	}

	public void setPropositionsReservees(List<Reservation> propositionsReservees) {
		this.propositionsReservees = propositionsReservees;
	}

}
