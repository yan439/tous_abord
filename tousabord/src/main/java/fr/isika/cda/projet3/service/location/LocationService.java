package fr.isika.cda.projet3.service.location;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Location;
import fr.isika.cda.projet3.repository.location.ILocationRepository;

@Stateless
public class LocationService implements ILocationService {

	@Inject
	private ILocationRepository locationRepository;
	
	@Override
	public void creer(Location location) {
		locationRepository.creer(location);
	}

	@Override
	public void modifier(Location location) {
		locationRepository.modifier(location);
	}

	@Override
	public void supprimer(Long id) {
		locationRepository.supprimer(id);
	}

	@Override
	public Optional<Location> rechercherParId(Long id) {
		return locationRepository.rechercherParId(id);
	}

	@Override
	public List<Location> rechercherTout() {
		return locationRepository.rechercherTout();
	}

}
