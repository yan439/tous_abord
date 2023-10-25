package fr.isika.cda.projet3.service.livraison;

import java.util.List;
import java.util.Optional;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.service.IService;

public interface ILivraisonService extends IService<Livraison>{
	List<Colis> getListeColis(Long Id);
	Optional<Livraison> getLivraisonAvecColis(Long valueOf);
	List<Livraison> rechercherLivraisonsAvecStatutAEnAttente();
	List<Livraison> rechercherLivraisonsAvecStatutAPublie();
}
