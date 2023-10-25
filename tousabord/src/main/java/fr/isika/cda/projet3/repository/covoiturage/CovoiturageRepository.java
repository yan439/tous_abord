package fr.isika.cda.projet3.repository.covoiturage;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.services.Covoiturage;

@Stateless
public class CovoiturageRepository implements ICovoiturageRepository {

	@PersistenceContext
	private EntityManager em;

	public Covoiturage creer(Covoiturage covoiturage) {
		em.persist(covoiturage);
		return covoiturage;
	}

	public void modifier(Covoiturage covoiturage) {
		em.merge(covoiturage);
	}

	public void supprimer(Long id) {
		Optional<Covoiturage> opt = rechercherParId(id);
		if (opt.isPresent())
			em.remove(opt.get());
	}

	public Optional<Covoiturage> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Covoiturage.class, id));
	}

	public List<Covoiturage> rechercherTout() {
		return em.createQuery("select t from Covoiturage t", Covoiturage.class).getResultList();
	}

}
