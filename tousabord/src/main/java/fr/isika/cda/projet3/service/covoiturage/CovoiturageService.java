package fr.isika.cda.projet3.service.covoiturage;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Covoiturage;
import fr.isika.cda.projet3.repository.covoiturage.ICovoiturageRepository;

@Stateless
public class CovoiturageService implements ICovoiturageService {

	
	@Inject
	private ICovoiturageRepository covoiturageRepository;
	
	@Override
	public void creer(Covoiturage covoiturage) {
		covoiturageRepository.creer(covoiturage);
		
	}

	@Override
	public void modifier(Covoiturage covoiturage) {
		covoiturageRepository.modifier(covoiturage);
		
	}

	@Override
	public void supprimer(Long id) {
		covoiturageRepository.supprimer(id);
		
	}

	@Override
	public Optional<Covoiturage> rechercherParId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Covoiturage> rechercherTout() {
		return covoiturageRepository.rechercherTout();
		
	}

	
	
	
}
