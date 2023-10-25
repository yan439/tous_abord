package fr.isika.cda.projet3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Covoiturage;
import fr.isika.cda.projet3.entity.services.Location;
import fr.isika.cda.projet3.entity.utilisateurs.Organisation;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.colis.IColisService;
import fr.isika.cda.projet3.service.compte.ICompteService;
import fr.isika.cda.projet3.service.covoiturage.ICovoiturageService;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;
import fr.isika.cda.projet3.service.location.ILocationService;
import fr.isika.cda.projet3.service.organisation.IOrganisationService;
import fr.isika.cda.projet3.service.reservation.IReservationService;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;

@ManagedBean
@ViewScoped
public class AdminTableauBord {

	@Inject
	private IUtilisateurService utilisateurService;
	
	@Inject
	private IOrganisationService organisationService;
	
	
	@Inject
	private ICompteService compteService;
	@Inject
	private IColisService colisService;
	@Inject
	private ICovoiturageService covoiturageService;
	@Inject
	private ILivraisonService livraisonService;
	@Inject
	private ILocationService locationService;
	@Inject
	private IReservationService reservationService;
	

	
	private List<Utilisateur> listeUtilisateurs=new ArrayList<>();
	private List<Organisation> listeOrganisations = new ArrayList<>();
	private List<Colis> listeColis= new ArrayList<>();
	private List<Covoiturage>listeCovoiturages= new ArrayList<>();
	private List<Location> listeLocations= new ArrayList<>();
	private List<Reservation>listeReservations= new ArrayList<>();
	
	 @PostConstruct
	    public void init() {
	    	this.listeUtilisateurs=utilisateurService.rechercherTout();
	    	this.listeOrganisations=organisationService.rechercherTout();
	    	this.listeColis=colisService.rechercherTout();
	    	this.listeCovoiturages=covoiturageService.rechercherTout();
	    	this.listeLocations=locationService.rechercherTout();
	    	this.listeReservations=reservationService.rechercherTout();
	    }
	
}
