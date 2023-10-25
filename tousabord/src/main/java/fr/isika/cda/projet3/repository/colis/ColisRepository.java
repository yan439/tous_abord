package fr.isika.cda.projet3.repository.colis
;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.Livraison;


@Stateless
public class ColisRepository implements IColisRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Colis creer(Colis colis) {

		em.persist(colis);
		return colis;
	}

	@Override
	public void modifier(Colis colis) {
		em.merge(colis);

	}

//	public void modifier(Long id) {
//		Optional<Livraison> opt = rechercherParId(id);
//		if (opt.isPresent()) {
//			em.merge(opt.get());
//		}
//
//	}

	@Override
	public void supprimer(Long id) {
		Optional<Colis> opt = rechercherParId(id);
		if (opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public Optional<Colis> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Colis.class, id));
	}

	@Override
	public List<Colis> rechercherTout() {
		return em.createQuery("select c from Colis c ", Colis.class).getResultList();
		
	}

}
