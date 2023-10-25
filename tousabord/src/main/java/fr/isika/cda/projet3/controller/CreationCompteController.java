package fr.isika.cda.projet3.controller;

import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.repository.utilisateurs.compte.ICompteRepository;
import fr.isika.cda.projet3.service.utilisateur.IUtilisateurService;

@ManagedBean
@ViewScoped
public class CreationCompteController {

	@Inject
	private IUtilisateurService utilisateurService;

	@Inject
	private ICompteRepository compteRepository;

	private Utilisateur utilisateur = new Utilisateur();

	@NotEmpty(message = "Required")
	@NotNull(message = "Required")
	@Email
	private String email;

	@NotEmpty(message = "Required")
	@NotNull(message = "Required")
	private String motDePasse;

	public String creerCompte() {
		Optional<Compte> optional = compteRepository.rechercherParEmail(email);
		if (!optional.isPresent()) {
			utilisateur.getInfoPersonnelle().setImagePath("/img/utilisateur/users.png");
			utilisateur.getCompte().setEmail(email);
			utilisateur.getCompte().setMotDePasse(motDePasse);
			utilisateur.getCompte().setRole(Role.UTILISATEUR);
			utilisateurService.creer(utilisateur);
		}
		return "connexion.xhtml?faces-redirect=true";
	}
	


	/* Getters / Setters */

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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}