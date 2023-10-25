package fr.isika.cda.projet3.service.compte;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.repository.utilisateurs.compte.ICompteRepository;

@Stateless
public class CompteService implements ICompteService {

	@Inject
	private ICompteRepository compteRepository;

	@Override
	public void creer(Compte compte) {
		compteRepository.creer(compte);
	}

	@Override
	public void modifier(Compte compte) {
		compteRepository.modifier(compte);
	}

	@Override
	public void supprimer(Long id) {
		compteRepository.supprimer(id);
	}

	@Override
	public Optional<Compte> rechercherParId(Long id) {
		return compteRepository.rechercherParId(id);
	}

	@Override
	public List<Compte> rechercherTout() {
		return compteRepository.rechercherTout();
	}

	@Override
	public Optional<Compte> rechercherParEmail(String email) {
		return compteRepository.rechercherParEmail(email);
	}
	
	
}
