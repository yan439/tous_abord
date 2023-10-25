package fr.isika.cda.projet3.repository.livraison;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.services.Colis;
import fr.isika.cda.projet3.entity.services.EtatService;
import fr.isika.cda.projet3.entity.services.Livraison;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;


@Stateless
public class LivraisonRepository implements ILivraisonRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Livraison creer(Livraison livraison) {

		em.persist(livraison);

		return livraison;
	}

	@Override
	public void modifier(Livraison livraison) {
		em.merge(livraison);

	}


	@Override
	public void supprimer(Long id) {
		Optional<Livraison> opt = rechercherParId(id);
		if (opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public Optional<Livraison> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Livraison.class, id));
	}

	@Override
	public Optional<Livraison> getLivraisonAvecColis(Long id) {
		return Optional.ofNullable(
				em.createQuery("SELECT l FROM Livraison l LEFT JOIN FETCH l.colis WHERE l.id=:id", Livraison.class)
						.setParameter("id", id).getSingleResult());
	}
	
	
	
	@Override
	public List<Livraison> rechercherTout() {
		return em.createQuery("select l from Livraison l join fetch l.colis", Livraison.class).getResultList();
	}
	

	@Override
	public List<Livraison> rechercherLivraisonsAvecStatutAEnAttente() {
		String query = "SELECT l FROM Livraison l join fetch l.colis WHERE l.etatService=:id";
		List<Livraison> livraison  = em.createQuery(query, Livraison.class).setParameter("id", EtatService.EN_ATTENTE).getResultList();
		return livraison ;
	}
	
	@Override
	public List<Livraison> rechercherLivraisonsAvecStatutAPublie() {
		String query = "SELECT l FROM Livraison l join fetch l.colis WHERE l.etatService=:id";
		List<Livraison> livraison  = em.createQuery(query, Livraison.class).setParameter("id", EtatService.PUBLIE).getResultList();
		return livraison ;
	}

	@Override
	public List<Colis> getListeColis(Long Id) {
		String query = "SELECT l FROM Livraison l join fetch l.colis WHERE l.id=:id";
		Livraison livraison  = em.createQuery(query, Livraison.class).setParameter("id", Id).getSingleResult();
		return livraison.getColis();
	}

}
