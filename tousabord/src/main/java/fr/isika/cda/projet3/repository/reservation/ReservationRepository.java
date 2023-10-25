package fr.isika.cda.projet3.repository.reservation;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.reservation.Reservation;

@Stateless
public class ReservationRepository implements IReservationRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Reservation creer(Reservation reservation) {

		em.persist(reservation);

		return reservation;
	}

	@Override
	public void modifier(Reservation reservation) {
		em.merge(reservation);

	}

//	public void modifier(Long id) {
//		Optional<Livraison> opt = rechercherParId(id);
//		if (opt.isPresent()) {
//			em.merge(opt.get());
//		}
//
//	}

	@Override
	public Optional<Reservation> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Reservation.class, id));
	}

	@Override
	public void supprimer(Long id) {
		Optional<Reservation> opt = rechercherParId(id);
		if (opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public List<Reservation> rechercherTout() {
		return em.createQuery("select r from Reservation r", Reservation.class).getResultList();
	}

}
