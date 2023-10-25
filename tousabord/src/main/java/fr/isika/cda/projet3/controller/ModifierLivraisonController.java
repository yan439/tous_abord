package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;


@ManagedBean
@ViewScoped
public class ModifierLivraisonController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ILivraisonService livraisonService;

	private Livraison livraison;
	
	private List<Colis> listeColis;

	private Colis colis = new Colis();
	
	@PostConstruct
	public void init() {
		Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String livraisonId = map.get("livraisonId");
		if(livraisonId != null) {
			Optional<Livraison> optional = livraisonService.rechercherParId(Long.valueOf(livraisonId));
			if(optional.isPresent()) {
				this.livraison = optional.get();
				
				//Récupération de la liste des colis associés à la livraison
				this.listeColis = livraisonService.getListeColis(livraison.getId());
			}
		}
		this.colis = new Colis();
	}
	
	public String showModifierLivraison() {
		return "modifier-livraison.xhtml";
	}
	
	public String showModifierLivraisonColis() {
		return "modifier-livraison-colis.xhtml";
	}
		public String modifierLivraison() {
		
		// avant de modifier la livraison
		// 1 - chercher le colis dans la liste des colis de la liv
		
		// 2 - modifier cet objet
		
		// ensuite faire la mise à jour
		
		livraisonService.modifier(livraison);
		init();
		return "/pages/client/profil-utilisateur.xhtml";
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

	public List<Colis> getListeColis() {
		return listeColis;
	}

	public void setListeColis(List<Colis> listeColis) {
		this.listeColis = listeColis;
	}

}
