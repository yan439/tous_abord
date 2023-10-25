package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.EtatService;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;
import fr.isika.cda.projet3.utils.SessionUtils;


@ManagedBean
@SessionScoped
public class LivraisonController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ILivraisonService livraisonService;
	
	@Inject
	private IUtilisateurService utilisateurService;

	private Livraison livraison = new Livraison();

	private Colis colis = new Colis();
	
	private Utilisateur utilisateur = new Utilisateur() ;

	private List<Livraison> livraisons = new ArrayList<>();
		

	@PostConstruct
	public void init() {
		this.livraisons = livraisonService.rechercherLivraisonsAvecStatutAPublie();
		this.livraison = new Livraison();
		
		this.colis = new Colis();
	}
	
	public String creerLivraison() {		
		Long userId = SessionUtils.getUtilisateurId();
		if(userId != null) {
			Optional<Utilisateur> opt = utilisateurService.getUtilisateurAvecServices(userId);
			if (opt.isPresent()) {
				this.utilisateur = opt.get();
				livraison.setIdContributeur(userId);
				
				//j'aoute le service à l'utilisateur
				livraison.ajouterColis(colis);
				this.livraison.setEtatService(EtatService.EN_ATTENTE);
			 this.livraison.setImagePath(utilisateur.getInfoPersonnelle().getImagePath());// hamid ??
				utilisateur.addService(livraison);
				
				//Je fusionne les modifications 
				livraisonService.creer(livraison);
				utilisateurService.modifier(utilisateur);
			}
		} else {
			System.err.println("Parameter : userId not found");
		}
		return "/pages/client/profil-utilisateur.xhtml";
	}

	//Supprimer une livraison
	public void supprimerLivraison(Long id) {
		// dissocier le service de l'utilisateur
		Long userId = SessionUtils.getUtilisateurId();
		Optional<Utilisateur> optional = utilisateurService.getUtilisateurAvecServices(userId);
		if (optional.isPresent()) {
			utilisateur = optional.get();
			utilisateur.removeService(id);
			utilisateurService.modifier(utilisateur);
			
			// supprimer le service
			livraisonService.supprimer(id);
		}
	}

	//Afficher la page de modification de la livraison
	public String showModifierLivraison() {
		return "/pages/client/modifier-livraison.xhtml";
	}
	
	//Afficher la page des colis
		public String showListeDesColis() {
			return "/pages/livraison/detail-colis.xhtml";
		}
	
	// Afficher la page d'ajout de colis pour une réservation
	public String showAjouterColis() {
		return "/pages/livraison/ajout-colis.xhtml";
	}
		
	
	public String modifierLivraison() {
		livraisonService.modifier(livraison);
		init();
		return "index.xhtml";
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public List<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
