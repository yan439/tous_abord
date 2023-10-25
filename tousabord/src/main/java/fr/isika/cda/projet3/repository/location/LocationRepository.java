package fr.isika.cda.projet3.repository.location;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.services.Location;

@Stateless
public class LocationRepository implements ILocationRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Location creer(Location location) {
		em.persist(location);
		return location;
	}

	@Override
	public void modifier(Location location) {
		em.merge(location);		
	}

	@Override
	public void supprimer(Long id) {
		Optional<Location> opt = rechercherParId(id);
		if(opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public Optional<Location> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Location.class, id));
	}

	@Override
	public List<Location> rechercherTout() {
		return em.createQuery("select l from location l", Location.class).getResultList();
	}

}
