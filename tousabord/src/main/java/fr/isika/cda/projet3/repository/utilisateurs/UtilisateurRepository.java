package fr.isika.cda.projet3.repository.utilisateurs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Stateless
public class UtilisateurRepository implements IUtilisateurRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Utilisateur creer(Utilisateur utilisateur) {
		// utilisateur.setMontant(crypterDonnee(utilisateur.getMontant()));
		em.persist(utilisateur);
		return utilisateur;
	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Override
	public void supprimer(Long id) {
		Optional<Utilisateur> opt = rechercherParId(id);
		if (opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public Optional<Utilisateur> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Utilisateur.class, id));
	}
	
	@Override
	public Optional<Utilisateur> rechercherParIdService(Long idService) {
//		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.services WHERE u.id=:id";
		String query = "SELECT u FROM Utilisateur u LEFT JOIN Utilisateur_Service us ON us.Utilisateur_id=u.id LEFT JOIN Service s ON us.services_id=:id";
		Utilisateur utilisateur = em.createQuery(query, Utilisateur.class).setParameter("id", idService).getSingleResult();
		return Optional.ofNullable(utilisateur);
	}
	
//	public static void main(String[] args) {
//		
//		Optional<Utilisateur> test = rechercherParIdService(Long idService);
//	}
	


	@Override
	public Optional<Utilisateur> getUtilisateurAvecServices(Long id) {
		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.services serv WHERE u.id=:id";
		return Optional.ofNullable(em.createQuery(query, Utilisateur.class).setParameter("id", id).getSingleResult());
	}
	
	public List<Service> getServices(Long Id) {
		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.services serv WHERE u.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", Id).getSingleResult();
		return user.getServices();
	}
	
	
	@Override
	public List<Reservation> getReservations(Long Id) {
		
		String query = "SELECT u FROM Utilisateur u  LEFT JOIN FETCH  u.reservations reser WHERE u.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", Id).getSingleResult();
		return user.getReservations();
	}
	
	@Override
	public List<Reservation> getReservationsAvecServices(Long Id) {
		List<Reservation> liste = new ArrayList<Reservation>();
		String query = "SELECT r FROM Reservation r LEFT JOIN FETCH r.service serv WHERE serv.id =:id";
		liste = em.createQuery(query, Reservation.class).setParameter("id", Id).getResultList();
		return liste;
	}
	
	@Override
	public List<Reservation> getReservationsPourContributeur(Long Id) {
		
		String query = "SELECT u FROM Utilisateur u  LEFT JOIN FETCH  u.reservations reser WHERE u.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", Id).getSingleResult();
		return user.getReservations();
	}
	
	@Override
	public List<Reservation> getPropositionsReserver(Long Id) {
	
		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH  u.reservations reser WHERE reser.service.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", Id).getSingleResult();
		return user.getReservations();
	}
	
	@Override
	public Optional<Utilisateur> getConsommateurAvecReservations(Long id) {
		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.reservations serv WHERE u.id=:id";
		return Optional.ofNullable(em.createQuery(query, Utilisateur.class).setParameter("id", id).getSingleResult());
	}
	
	@Override
	public Optional<Utilisateur> getContributeurAvecServices(Long id) {
		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.services serv WHERE serv.id=:id";
		return Optional.ofNullable(em.createQuery(query, Utilisateur.class).setParameter("id", id).getSingleResult());
	}
	

	
	

	@Override
	public List<Utilisateur> rechercherTout() {
		return em.createQuery("select u from Utilisateur u", Utilisateur.class).getResultList();
	}

	public List<Don> getDons(Long Id) {
		String query = "SELECT u FROM Utilisateur u JOIN FETCH u.dons WHERE u.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", Id).getSingleResult();
		return user.getDons();
	}





	public List<Vehicule> getVehicule(Long Id) {
		String query = "SELECT u FROM Utilisateur u JOIN FETCH u.vehicules WHERE u.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", Id).getSingleResult();
		return user.getVehicules();
	}

	@Override
	public Optional<Utilisateur> rechercheParCompteId(Long compteId) {
		String query = "SELECT u FROM Utilisateur u LEFT JOIN FETCH u.compte c WHERE c.id=:id";
		Utilisateur user = em.createQuery(query, Utilisateur.class).setParameter("id", compteId).getSingleResult();
		return Optional.ofNullable(user);
	}

	

//	public static String crypterDonnee(String donneeACrypter) {
//
//		String donneeCryptee = "";
//
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(donneeACrypter.getBytes());
//			byte[] bytes = md.digest();
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; i < bytes.length; i++) {
//				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//			}
//			donneeCryptee = sb.toString();
//
//		} catch (NoSuchAlgorithmException e) {
//			System.out.println(e);
//		}
//
//		return donneeCryptee;
//	}

}
