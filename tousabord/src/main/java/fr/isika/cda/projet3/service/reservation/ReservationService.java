package fr.isika.cda.projet3.service.reservation;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.reservation.Reservation;
import fr.isika.cda.projet3.repository.reservation.IReservationRepository;

@Stateless
public class ReservationService implements IReservationService {
	
	@Inject
	private IReservationRepository reservationRepository;

	
	public void creer(Reservation reservation) {
		
		reservationRepository.creer(reservation);
	}

	@Override
	public void modifier(Reservation reservation) {
		reservationRepository.modifier(reservation);	
	}
	


	@Override
	public void supprimer(Long id) {
		reservationRepository.supprimer(id);
		
	}

	@Override
	public Optional<Reservation> rechercherParId(Long id) {
		return reservationRepository.rechercherParId(id);
	}

	@Override
	public List<Reservation> rechercherTout() {
		return reservationRepository.rechercherTout();
	
	}

}
