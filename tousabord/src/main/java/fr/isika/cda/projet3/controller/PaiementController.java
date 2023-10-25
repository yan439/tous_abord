
package fr.isika.cda.projet3.controller;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.paiements.Transaction;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.repository.utilisateurs.compte.ICompteRepository;
import fr.isika.cda.projet3.service.reservation.IReservationService;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;

@ManagedBean
@SessionScoped
public class PaiementController implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 331374416639694446L;

	@Inject
	private IReservationService reservationService;
	
	@Inject
	private IUtilisateurService utilisateurService;
	
	@Inject
	private ICompteRepository compteRepository;
	
	private Reservation reservation;
	
	private Utilisateur contributeur;
	
	private LocalDate dateTransaction = LocalDate.now();
	
//	public void loadReservation() {
//		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//		String idReser = map.get("reserId");
//		
//		if (idReser != null) {
//			Optional<Reservation> optional = reservationService.rechercherParId(Long.valueOf(idReser));
//			if (optional.isPresent()) {
//				reservation = optional.get();
//				Service serviceAPayer = reservation.getService();
//				Optional<Utilisateur> optUtil = utilisateurService.rechercherParId(serviceAPayer.getIdContributeur());
//				if (optUtil.isPresent()) {
//					contributeur = optUtil.get();
//				}
//			}
//		}
//	}
	
	public void accederPaiementReservation() throws IOException {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String idReser = map.get("reserId");
		
		if (idReser != null) {
			Optional<Reservation> optional = reservationService.rechercherParId(Long.valueOf(idReser));
			if (optional.isPresent()) {
				reservation = optional.get();
				Service serviceAPayer = reservation.getService();
				Optional<Utilisateur> optUtil = utilisateurService.rechercherParId(serviceAPayer.getIdContributeur());
				if (optUtil.isPresent()) {
					contributeur = optUtil.get();
				}
			}
		}
				
//		return "./formulairePaiement.xhtml";
		FacesContext.getCurrentInstance().getExternalContext().redirect("./formulairePaiement.xhtml?reserId=" + reservation.getId());
	}

	public void payerReservation() {
		Optional<Reservation> optional = reservationService.rechercherParId(reservation.getId());
		if (optional.isPresent()) {
			reservation = optional.get();
			BigDecimal sommeAPayer = reservation.getService().getMontant();
			Compte compteConsommateur = reservation.getUtilisateur().getCompte();
			System.out.println(compteConsommateur.getSolde());
			compteConsommateur.setSolde(compteConsommateur.getSolde().subtract(sommeAPayer));
			System.out.println(compteConsommateur.getSolde());
			compteRepository.modifier(compteConsommateur);
			
			Optional<Compte> opt = compteRepository.rechercherParRole(Role.ADMIN);
			if (opt.isPresent()) {
				Compte compteAdmin = opt.get();
				System.out.println(compteAdmin.getSolde());
				compteAdmin.setSolde(compteAdmin.getSolde().add(sommeAPayer));
				System.out.println(compteAdmin.getSolde());
				compteRepository.modifier(compteAdmin);
			}
		}
		
//		return "./profil-utilisateur.xhtml";
	}
	
	public String retournerAuProfil() {
		return "./profil-utilisateur.xhtml";
	}
	
	public void payerContributeur(Long idReservation) {
		Optional<Reservation> optional = reservationService.rechercherParId(idReservation);
		if (optional.isPresent()) {
			reservation = optional.get();
			
			BigDecimal prixService = reservation.getService().getMontant();
			
			Optional<Compte> opt = compteRepository.rechercherParRole(Role.ADMIN);
			if (opt.isPresent()) {
				Compte compteAdmin = opt.get();
				BigDecimal soldeAdmin = compteAdmin.getSolde();
				BigDecimal prelevement = preleverCommission(prixService);
				soldeAdmin = soldeAdmin.subtract(prelevement);
				BigDecimal soldeContributeur = reservation.getUtilisateur().getCompte().getSolde();
				soldeContributeur = soldeContributeur.add(prixService);
			}
		}
	}
	

//	public void rembourserConsommateur() {
//		Optional<Reservation> optional = reservationService.rechercherParId(idReservation);
//		if (optional.isPresent()) {
//			BigDecimal soldeConsommateur = reservation.getUtilisateur().getCompte().getSolde();
//			soldeConsommateur.add(reservation.getService().getMontant());
//			BigDecimal soldeAdmin = reservation.getUtilisateur().getCompte().getSolde();
//			soldeAdmin.subtract(reservation.getService().getMontant());		}
//	}

	
	public BigDecimal preleverCommission(BigDecimal valeur) {
		BigDecimal commission = new BigDecimal(0.05);
		return valeur.subtract(valeur.multiply(commission));
	}

	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}
	
	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
	
	public Utilisateur getContributeur() {
		return contributeur;
	}
	
	public void setContributeur(Utilisateur contributeur) {
		this.contributeur = contributeur;
	}
	
}	

