package fr.isika.cda.projet3.repository.utilisateurs.compte;

import java.util.Optional;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.repository.IRepository;

public interface ICompteRepository extends IRepository<Compte> {

	Optional<Compte> rechercherParRole(Role role);
	
	Optional<Compte> rechercherParEmail(String email);
}
