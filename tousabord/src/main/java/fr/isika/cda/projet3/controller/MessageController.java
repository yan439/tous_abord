package fr.isika.cda.projet3.controller;

import java.util.Optional;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.utilisateurs.Message;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.message.IMessageService;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;
import fr.isika.cda.projet3.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class MessageController {

	@Inject
	private IMessageService messageService;
	
	@Inject
	private IUtilisateurService utilisateurService;
	
	private Message message;


	public String contacter(Long idDestinataire) {
		
		Optional<Utilisateur> optional = utilisateurService.rechercherParId(idDestinataire);
		if (optional.isPresent()) {
			Utilisateur destinataire = optional.get();
			message.setDestinataire(destinataire.getInfoPersonnelle().getPrenom() + destinataire.getInfoPersonnelle().getNom().toUpperCase());	
		}
	
		return "/pages/formulaireEnvoiMessage.xhtml";

	}

//	public String envoyerMessage(Message message) {
//		Long idExpediteur = SessionUtils.getUtilisateurId();
///		message.setIdExpediteur(idExpediteur);
//
//        messageService.AjouterMessage
//        (
//            DateTime.Now.ToShortDateString(),
//            DateTime.Now.ToShortTimeString(),
//            message.destinataire,
//            message.objetDuMessage,
//            message.corpsDuMessage,
//            "Envoyé",
//            "Non lu",
//            IdExpediteur
//        );
//
//        return "MaMessagerie";
//     }
//
//	public String maMessagerie() {
//		int UtilisateurId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
//        Utilisateur utilisateur = dalUtilisateur.ObtenirCompte(UtilisateurId);
//        String Destinataire = utilisateur.Nom.ToUpper() + " " + utilisateur.Prenom;
//
//        SecretariatViewModel svm = new SecretariatViewModel
//        {
//            messages = dalMessage.ObtenirTousLesMessages().ToList(),
//            messagesRecus = dalMessage.ObtenirTousLesMessages().Where(m => m.Destinataire == Destinataire).ToList(),
//            messagesEnvoyes = dalMessage.ObtenirTousLesMessages().Where(m => m.UtilisateurId == UtilisateurId).ToList(),
//        };
//
//        return "";
//    }
//
//	public String supprimerMessage(int id, String etatCoteExpediteur, String etatCoteDestinataire) {
//		Message message = dalMessage.ObtenirMessage(id);
//		message.etatCoteExpediteur = etatCoteExpediteur;
//		message.etatCoteDestinataire = etatCoteDestinataire;
//		dalMessage.ModifierMessage(message);
//
//		if (message.etatCoteExpediteur.Equals("Supprimé") && message.etatCoteDestinataire.Equals("Supprimé")) {
//			messageService.supprimerMessage(message.Id);
//		}
//
//		return "MaMessagerie";
//	}
	
	public Message getMessage() {
		return message;
	}
	
	public void setMessage(Message message) {
		this.message = message;
	}
}
