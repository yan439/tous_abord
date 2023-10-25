package fr.isika.cda.projet3.service.utilisateur;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.repository.utilisateurs.IUtilisateurRepository;

@Stateless
public class UtilisateurService implements IUtilisateurService {

	@Inject
	private IUtilisateurRepository utilisateurRepository;

	public void creer(Utilisateur utilisateur) {
		utilisateurRepository.creer(utilisateur);
	}

	public void modifier(Utilisateur utilisateur) {
		utilisateurRepository.modifier(utilisateur);
	}

	@Override
	public void supprimer(Long id) {
		utilisateurRepository.supprimer(id);
	}

	public IUtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

	public void setUtilisateurRepository(IUtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public Optional<Utilisateur> rechercherParId(Long id) {
		return utilisateurRepository.rechercherParId(id);
	}
	
//	@Override
//	public Optional<Utilisateur> rechercherParIdService(Long idService) {
//		return utilisateurRepository.rechercherParIdService(idService);
//	}

	
	

	@Override
	public Optional<Utilisateur> getUtilisateurAvecServices(Long id) {
		return utilisateurRepository.getUtilisateurAvecServices(id);
	}

	@Override
	public List<Utilisateur> rechercherTout() {
		return utilisateurRepository.rechercherTout();
	}

	@Override
	public List<Service> getServices(Long Id) {
		return utilisateurRepository.getServices(Id);

	}

	@Override
	public List<Vehicule> getVehicule(Long Id) {
		return utilisateurRepository.getVehicule(Id);
	}

	@Override
	public List<Don> getDons(Long Id) {

		return utilisateurRepository.getDons(Id);
	}

	@Override
	public Optional<Utilisateur> getContributeurAvecServices(Long id) {
		return utilisateurRepository.getContributeurAvecServices(id);
	}

	@Override
	public Optional<Utilisateur> getConsommateurAvecReservations(Long id) {
		return utilisateurRepository.getConsommateurAvecReservations(id);
	}

	@Override

	public Optional<Utilisateur> rechercheParCompteId(Long compteId) {
		return utilisateurRepository.rechercheParCompteId(compteId);
	}

	public List<Reservation> getReservations(Long Id) {
		return utilisateurRepository.getReservations(Id);
	}

	@Override
	public List<Reservation> getPropositionsReserver(Long Id) {
		return utilisateurRepository.getPropositionsReserver(Id);
	}

	@Override
	public List<Reservation> getReservationsAvecServices(Long Id) {
		return utilisateurRepository.getReservationsAvecServices(Id);
	}
}

//     public List<Service>getServices(Long Id){
//	return utilisateurRepository.getServices(Id);
//}
//     public List<Don>getDons(Long Id){
//    		return utilisateurRepository.getDons(Id);
//    	}
//     
//     public List<Vehicule>getVehicules(Long Id){
//    		return utilisateurRepository.getVehicule(Id);
//    	}
