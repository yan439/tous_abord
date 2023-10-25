package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.service.colis.IColisService;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;

@ManagedBean
@ViewScoped
public class ModifierLivraisonColisController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ILivraisonService livraisonService;

	@Inject
	private IColisService colisService;

	private Livraison livraison;

	private Colis colis;

	public void init() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String colisId = map.get("colisId");
		String livraisonId = map.get("livraisonId");
		
		if (colisId != null) {
			Optional<Colis> optional = colisService.rechercherParId(Long.valueOf(colisId));
			if (optional.isPresent()) {
				this.colis = optional.get();
				
			}
		}
		
		if (livraisonId != null) {
			Optional<Livraison> opt = livraisonService.rechercherParId(Long.valueOf(livraisonId));
			if (opt.isPresent()) {
				this.livraison = opt.get();
				
			}
		}

	}

	public String modifierColis() {
		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	//	String colisId = map.get("colisId");
		String livraisonId = map.get("livraisonId");
		
		if (livraisonId != null) {
			Optional<Livraison> opt = livraisonService.rechercherParId(Long.valueOf(livraisonId));
			if (opt.isPresent()) {
				this.livraison = opt.get();
				
				
				
				List<Colis> listeColis = new ArrayList<Colis>();
				listeColis.add(colis);
				livraison.setColis(listeColis);
				//this.livraison.ajouterColis(colis);
				livraisonService.modifier(livraison);
				return "index.xhtml";
			}
		}
		
		
		
		return "modifier-livraison.xhtml";
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

}
