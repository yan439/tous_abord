package fr.isika.cda.projet3.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.repository.utilisateurs.compte.ICompteRepository;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;
import fr.isika.cda.projet3.utils.SessionUtils;

@ManagedBean
@SessionScoped
public class ConnexionController2 implements Serializable {

	private static final long serialVersionUID = -11574855474L;

	@NotEmpty(message = "Required")
	@NotNull(message = "Required")
	@Email
	private String email;

	@NotEmpty(message = "Required")
	@NotNull(message = "Required")
	private String motDePasse;

	@Inject
	private IUtilisateurService utilisateurService;
	
	@Inject
	private ICompteRepository compteRepository;

	public String seConnecter() throws IOException {

		Optional<Compte> optional = compteRepository.rechercherParEmail(email);

		if (optional.isPresent()) {
			Compte compte = optional.get();
			if (compte.getEmail().equals(email) && compte.getMotDePasse().equals(motDePasse)) {
				Optional<Utilisateur> userOpt = utilisateurService.rechercheParCompteId(compte.getId());
				SessionUtils.setCompteConnecte(compte);
				SessionUtils.setUtilisateurConnecte(userOpt.get().getId());
				return "jomi2.xhtml?faces-redirect=true";
			} else {
				System.out.println("Wrong authentification");
			}
		}
		return "jomi2";
	}

	
	public Boolean estUtilisateur() {
		String role = SessionUtils.getRole();
		if (role != null && role.equals(Role.UTILISATEUR.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean estConnecte() {
		return SessionUtils.estConnecte();
	}
	
	public String seDeconnecter() {
		SessionUtils.resetSession();
		return "jomi2.xhtml?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}