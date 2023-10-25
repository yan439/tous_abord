package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.service.livraison.ILivraisonService;

@ManagedBean
@SessionScoped
public class AjouterColisController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ILivraisonService livraisonService;

	private Livraison livraison;

	private Colis colis = new Colis();

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

//	public String ajoutColis() {
//		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//		String livraisonId = map.get("livraisonId2");
//		if (livraisonId != null) {
//			Optional<Livraison> optional = livraisonService.rechercherParId(Long.valueOf(livraisonId));
//			if (optional.isPresent()) {
//				this.livraison = optional.get();
//				List<Colis> listeColis = new ArrayList<Colis>();
//				listeColis.add(colis);
//				livraison.setColis(listeColis);
//				// this.livraison.ajouterColis(colis);
//				livraisonService.modifier(livraison);
//				init();
//				return "index.xhtml";
//			}
//
//		}
//
//		return "modifier-livraison.xhtml";
//	}

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
