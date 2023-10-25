package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;
import fr.isika.cda.projet3.utils.FileUpload;
import fr.isika.cda.projet3.utils.SessionUtils;

@ManagedBean
@ViewScoped
public class UtilisateurController implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUtilisateurService utilisateurService;

	private Utilisateur utilisateur = new Utilisateur();
	private List<Utilisateur> listeUtilisateurs = new ArrayList<>();

	public String creercompteutilisateur() {
 
		utilisateurService.creer(utilisateur);

		System.out.println("Utilisateur créé !");
		return "creationcompteutilisateur.xhtml";
	}

	// utiliser pour appler modifier profil utilisateur avec insertion photo

	public void onLoad() {
		
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String userIdStr = map.get("userId");
	
		if(userIdStr != null) {
			Long userId = Long.valueOf(userIdStr);
			Optional<Utilisateur> opt = utilisateurService.rechercherParId(userId);
			if (opt.isPresent()) {
				this.utilisateur = opt.get();
		
			}
		} else {
			System.err.println("Parameter : userId not found");
		}
//		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//		Long compteId = (Long) session.getAttribute("Id");
//		if (compteId != null) {
//			Optional<Utilisateur> optionalUser = utilisateurService.rechercheParCompteId(compteId);
//			if (optionalUser.isPresent()) {
//				this.utilisateur = optionalUser.get();
//			} else {
//				System.err.println("User with compteId : " + compteId + " not found");
//			}
//		} else {
//			System.err.println("Parameter : Id (compte) not found : " + compteId);
//		}
	}

	@PostConstruct
	public void init() {
		this.listeUtilisateurs = utilisateurService.rechercherTout();
	}

	public void supprimerUtilisateur(long id) {
		System.out.println(utilisateur.getId());
		utilisateurService.supprimer(id);
	}

	public String modifierUtilisateur() {
		utilisateurService.modifier(utilisateur);
		if (utilisateur.getInfoPersonnelle().getImagePath() != null) {
			SessionUtils.updateSessionImage(utilisateur.getInfoPersonnelle().getImagePath());
		}
		System.out.println("utilisateur modifier");
		return "profil-utilisateur?id=" + utilisateur.getId() + "faces-redirect=true";
	}

	public void upload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		String filePath = "/utilisateur/" + file.getFileName();

		FileUpload.doUpload(file, filePath);
		utilisateur.getInfoPersonnelle().setImagePath("/img" + filePath);
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

}
