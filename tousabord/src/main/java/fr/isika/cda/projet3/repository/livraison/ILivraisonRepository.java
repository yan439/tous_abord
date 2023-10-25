package fr.isika.cda.projet3.repository.livraison;

import java.util.List;
import java.util.Optional;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.repository.IRepository;

public interface ILivraisonRepository extends IRepository<Livraison>{
	
	List<Colis> getListeColis(Long Id);

	Optional<Livraison> getLivraisonAvecColis(Long id);

	List<Livraison> rechercherLivraisonsAvecStatutAEnAttente();

	List<Livraison> rechercherLivraisonsAvecStatutAPublie();

}
