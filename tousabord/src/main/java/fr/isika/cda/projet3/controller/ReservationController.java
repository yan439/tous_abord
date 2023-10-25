package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.reservation.EtatReservation;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;
import fr.isika.cda.projet3.service.reservation.IReservationService;
import fr.isika.cda.projet3.service.reservation.ReservationService;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;
import fr.isika.cda.projet3.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class ReservationController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IReservationService reservationService;

	@Inject
	private ILivraisonService livraisonService;

	@Inject
	private IUtilisateurService utilisateurService;

	private Livraison livraison = new Livraison();

	private Colis colis = new Colis();

	private Reservation reservation = new Reservation();

	private Utilisateur utilisateur = new Utilisateur();

	private List<Reservation> reserContributeur = new ArrayList<>();
	
	public String creerReservation() {

		reservationService.creer(reservation);

		System.out.println("reservation créée !");

		return "jomi2.xhtml";

	}

	@PostConstruct
	public void init() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String livraisonId = map.get("livraisonId2");
		if (livraisonId != null) {
			Optional<Livraison> optional = livraisonService.rechercherParId(Long.valueOf(livraisonId));
			if (optional.isPresent()) {
				this.livraison = optional.get();

			}
		}
		
		
	}

	public String reserver() {

		Utilisateur contributeur = new Utilisateur();
		Utilisateur consommateur = new Utilisateur();
		// Je récupère l'id de la livraison qu'on souhaite réserver
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String livraisonId = map.get("livraisonId2");

		// Je teste si l'id est non null
		if (livraisonId != null) {

//			je récupère le contributeur qui a proposé le service 
			Optional<Utilisateur> optCon = utilisateurService.getContributeurAvecServices(Long.valueOf(livraisonId));
			if (optCon.isPresent()) {
				contributeur = optCon.get();
				System.out.println("l'id du contributeur est : " + contributeur.getId());
			}

//			Je récupère la livraison et je mets à jour sa liste de colis
			Optional<Livraison> optional = livraisonService.getLivraisonAvecColis(Long.valueOf(livraisonId));
			if (optional.isPresent()) {
				this.livraison = optional.get();

				// Je mets à jour le colis dans la livraison
				livraison.ajouterColis(colis);

				// Je mets à jour la livraison dans le contributeur
				contributeur.addService(livraison);
//				livraisonService.modifier(livraison);

				// Je merge les modifications
	//			utilisateurService.modifier(contributeur);

				// Je récupère l'id de la personne connectée à la session et qui effectue la
				// réservation
				Long userId = SessionUtils.getUtilisateurId();

				if (userId != null) {
					Optional<Utilisateur> opt = utilisateurService.rechercherParId(userId);
					if (opt.isPresent()) {
						consommateur = opt.get();

						// Je crée la réservation et j'ajoute les attributs
						reservation.setUtilisateur(consommateur);
						reservation.setService(livraison);
						reservation.setDateReservation(getTodaysDate());
						reservation.setEtatReservation(EtatReservation.EN_ATTENTE);
						reservationService.creer(reservation);

						// j'aoute la réservation créée à la liste des réservations du consommateur
						consommateur.addReservation(reservation);
						utilisateurService.modifier(consommateur);

		//			utilisateurService.modifier(contributeur);


						return "profil-utilisateur.xhtml";

					}

				}

			}
		}
		return "profil-utilisateur.xhtml";
	}



	public String accepterReservation(Long id) {
		
		Optional<Reservation> optReser = reservationService.rechercherParId(id);
		if(optReser.isPresent()) {
			reservation = optReser.get();
			if (reservation.getEtatReservation().equals(EtatReservation.EN_ATTENTE)) {
			reservation.setEtatReservation(EtatReservation.VALIDEE);
			reservationService.modifier(reservation);
			//init();
			return "pages/client/profil-utilisateur.xhtml";
			}
		}
		
		return "pages/client/profil-utilisateur.xhtml";
	}



	public String annulerReservation(Long id) {
		Optional<Reservation> optReser = reservationService.rechercherParId(id);
		if(optReser.isPresent()) {
			reservation = optReser.get();
			if (reservation.getEtatReservation().equals(EtatReservation.EN_ATTENTE) || reservation.getEtatReservation().equals(EtatReservation.VALIDEE)) {
			reservation.setEtatReservation(EtatReservation.ANNULEE);
			reservationService.modifier(reservation);
			//init();
			return "pages/client/profil-utilisateur.xhtml";
			}
		}
		return "pages/client/profil-utilisateur.xhtml";
	}

	public void refuserReservation(Long id) {
		Optional<Reservation> optReser = reservationService.rechercherParId(id);
		if(optReser.isPresent()) {
			reservation = optReser.get();
			if (reservation.getEtatReservation().equals(EtatReservation.EN_ATTENTE)) {
			reservation.setEtatReservation(EtatReservation.REFUSEE);
			reservationService.modifier(reservation);
			init();
			}
		}
	}



	public void supprimerReservation(Long id) {
		System.out.println(reservation.getId());
		reservationService.supprimer(id);
	}

	public String rechercherReservation(Long id) {

		Optional<Reservation> opt = reservationService.rechercherParId(id);
		if (opt.isPresent()) {
			reservation = opt.get();
			return "modifier-reservation.xhtml";

		}
		return "jomi2.xhtml";
	}

	public String modifierReservation() {
		reservationService.modifier(reservation);
		return "profil-utilisateur.xhtml";
	}

	private static Date getTodaysDate() {
		return Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Colis getColis() {
		return colis;
	}

	public void setColis(Colis colis) {
		this.colis = colis;
	}

	public List<Reservation> getReserContributeur() {
		return reserContributeur;
	}

	public void setReserContributeur(List<Reservation> reserContributeur) {
		this.reserContributeur = reserContributeur;
	}

}
