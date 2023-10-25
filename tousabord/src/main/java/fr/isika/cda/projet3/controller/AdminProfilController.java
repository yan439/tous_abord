package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.EtatService;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Role;

import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;

@SessionScoped
@ManagedBean
public class AdminProfilController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUtilisateurService utilisateurService;
	
	@Inject
	private ILivraisonService livraisonService;
	
	private Livraison livraison;
	
	private int nbreUtilisateurs;

	private int nbreDeServices;
	
	private int nbreDeServicesEnAttente;
	
	private int nbreDeServicesPublie;
	
	private int nbreDeServicesRefuse;
	
	private Utilisateur utilisateur;
	private List<Livraison> livraisons = new ArrayList<>();
	private List<Vehicule> vehicules = new ArrayList<>();
	private List<Reservation> reservations = new ArrayList<>();
	private List<Reservation> reserContributeur = new ArrayList<>();
	private List<Don> dons = new ArrayList<>();
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	@PostConstruct
	public void init() {
		
		//statistiques pour pages admin 
		nbreUtilisateurs = utilisateurService.rechercherTout().size();
		
		nbreDeServices = livraisonService.rechercherTout().size();
		
		nbreDeServicesEnAttente = livraisonService.rechercherLivraisonsAvecStatutAEnAttente().size();
		
		nbreDeServicesPublie = livraisonService.rechercherLivraisonsAvecStatutAPublie().size();
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long compteId = (Long) session.getAttribute("Id");
		if (compteId != null) {
			Optional<Utilisateur> optionalUser = utilisateurService.rechercheParCompteId(compteId);
			if (optionalUser.isPresent()) {
				this.utilisateur = optionalUser.get();
				Long userId = utilisateur.getId(); 
				this.livraisons = livraisonService.rechercherLivraisonsAvecStatutAEnAttente();
				this.utilisateurs = utilisateurService.rechercherTout();
				//this.reservations = utilisateurService.getReservations(userId);
//				
//				if (utilisateur.getRole().equals(Role.CONTRIBUTEUR)) {
//					this.reserContributeur = utilisateurService.getPropositionsReserver(reservation.getService().getId());
//				}
				
				
				
				// this.vehicules = utilisateurService.getVehicule(userId);
				// this.dons = utilisateurService.getDons(userId);
			} else {
				System.err.println("User with compteId : " + compteId + " not found");
			}
		} else {
			System.err.println("Parameter : Id (compte) not found : " + compteId);
		}
	}
	
	public void accepterProposition() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String livraisonId = map.get("livraisonId");
		
		if (livraisonId != null) {
			Optional<Livraison> opt = livraisonService.rechercherParId(Long.valueOf(livraisonId));
			if (opt.isPresent()) {
				this.setLivraison(opt.get());
				livraison.setEtatService(EtatService.PUBLIE);
				livraisonService.modifier(livraison);
			}
		}
	}
	
	public void refuserProposition() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String livraisonId = map.get("livraisonId");
		
		if (livraisonId != null) {
			Optional<Livraison> opt = livraisonService.rechercherParId(Long.valueOf(livraisonId));
			if (opt.isPresent()) {
				this.setLivraison(opt.get());
				livraison.setEtatService(EtatService.REFUSE);
				livraisonService.modifier(livraison);
			}
		}
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public List<Reservation> getReserContributeur() {
		return reserContributeur;
	}

	public void setReserContributeur(List<Reservation> reserContributeur) {
		this.reserContributeur = reserContributeur;
	}

	public List<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public int getNbreUtilisateurs() {
		return nbreUtilisateurs;
	}

	public void setNbreUtilisateurs(int nbreUtilisateurs) {
		this.nbreUtilisateurs = nbreUtilisateurs;
	}

	public int getNbreDeServices() {
		return nbreDeServices;
	}

	public void setNbreDeServices(int nbreDeServices) {
		this.nbreDeServices = nbreDeServices;
	}

	public int getNbreDeServicesEnAttente() {
		return nbreDeServicesEnAttente;
	}

	public void setNbreDeServicesEnAttente(int nbreDeServicesEnAttente) {
		this.nbreDeServicesEnAttente = nbreDeServicesEnAttente;
	}

	public int getNbreDeServicesPublie() {
		return nbreDeServicesPublie;
	}

	public void setNbreDeServicesPublie(int nbreDeServicesPublie) {
		this.nbreDeServicesPublie = nbreDeServicesPublie;
	}

	public int getNbreDeServicesRefuse() {
		return nbreDeServicesRefuse;
	}

	public void setNbreDeServicesRefuse(int nbreDeServicesRefuse) {
		this.nbreDeServicesRefuse = nbreDeServicesRefuse;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}
