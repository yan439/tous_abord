package fr.isika.cda.projet3.service.livraison;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.repository.livraison.ILivraisonRepository;

@Stateless
public class LivraisonService implements ILivraisonService {
	
	@Inject
	private ILivraisonRepository livraisonRepository;

	
	public void creer(Livraison livraison) {
		
		livraisonRepository.creer(livraison);
	}

	@Override
	public void modifier(Livraison livraison) {
		livraisonRepository.modifier(livraison);	
	}
	
	@Override
	public Optional<Livraison> getLivraisonAvecColis(Long valueOf) {
		return livraisonRepository.getLivraisonAvecColis(valueOf);
	}

	@Override
	public void supprimer(Long id) {
		livraisonRepository.supprimer(id);
		
	}

	@Override
	public Optional<Livraison> rechercherParId(Long id) {
		return livraisonRepository.rechercherParId(id);
	}

	@Override
	public List<Livraison> rechercherTout() {
		return livraisonRepository.rechercherTout();
	
	}

	@Override
	public List<Colis> getListeColis(Long Id) {
		return livraisonRepository.getListeColis(Id);
	}

	@Override
	public List<Livraison> rechercherLivraisonsAvecStatutAEnAttente() {
		return livraisonRepository.rechercherLivraisonsAvecStatutAEnAttente();
	}

	@Override
	public List<Livraison> rechercherLivraisonsAvecStatutAPublie() {
		return livraisonRepository.rechercherLivraisonsAvecStatutAPublie();
	}

}
