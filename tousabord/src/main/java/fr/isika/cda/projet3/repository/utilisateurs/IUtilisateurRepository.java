package fr.isika.cda.projet3.repository.utilisateurs;

import java.util.List;
import java.util.Optional;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.repository.IRepository;

public interface IUtilisateurRepository extends IRepository<Utilisateur> {

	Optional<Utilisateur> rechercherParIdService(Long idService);

	List<Service> getServices(Long Id);

	List<Vehicule> getVehicule(Long Id);

	List<Don> getDons(Long Id);

	Optional<Utilisateur> getUtilisateurAvecServices(Long id);

	Optional<Utilisateur> getContributeurAvecServices(Long id);

	Optional<Utilisateur> getConsommateurAvecReservations(Long id);

	Optional<Utilisateur> rechercheParCompteId(Long compteId);

	List<Reservation> getReservations(Long Id);

	List<Reservation> getPropositionsReserver(Long Id);

	List<Reservation> getReservationsPourContributeur(Long Id);

	List<Reservation> getReservationsAvecServices(Long Id);

	
	
     
}
