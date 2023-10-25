package fr.isika.cda.projet3.service.colis;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.repository.colis.IColisRepository;
import fr.isika.cda.projet3.repository.livraison.ILivraisonRepository;

@Stateless
public class ColisService implements IColisService {
	
	@Inject
	private IColisRepository colisRepository;

	
	public void creer(Colis colis) {
		
		colisRepository.creer(colis);
	}

	@Override
	public void modifier(Colis colis) {
		colisRepository.modifier(colis);	
	}
	


	@Override
	public void supprimer(Long id) {
		colisRepository.supprimer(id);
		
	}

	@Override
	public Optional<Colis> rechercherParId(Long id) {
		return colisRepository.rechercherParId(id);
	}

	@Override
	public List<Colis> rechercherTout() {
		return colisRepository.rechercherTout();
	
	}

}
