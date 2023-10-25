package fr.isika.cda.projet3.service.compte;

import java.util.Optional;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.service.IService;

public interface ICompteService extends IService<Compte> {

	public Optional<Compte> rechercherParEmail(String email);
	
}
