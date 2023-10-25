package fr.isika.cda.projet3.repository.utilisateurs.compte;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Stateless
public class CompteRepository implements ICompteRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Compte creer(Compte compte) {
		em.persist(compte);
		return compte;
	}

	@Override
	public void modifier(Compte compte) {
		em.merge(compte);
	}
	
	@Override
	public void supprimer(Long id) {
		Optional<Compte> opt = rechercherParId(id);
		if(opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public Optional<Compte> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Compte.class, id));
	}

	@Override
	public Optional<Compte> rechercherParRole(Role role) {
		try {
			Optional<Compte> opt = Optional
					.ofNullable(em.createQuery("SELECT c FROM Compte c WHERE c.role=:role ", Compte.class)
							.setParameter("role", role).getSingleResult());
			return opt;
		} catch (NoResultException ex) {
			System.out.println(ex);
		}
		return Optional.empty();
	}
	
	@Override
	public List<Compte> rechercherTout() {
		return em.createQuery("SELECT c FROM compte c", Compte.class).getResultList();
	}

	@Override
	public Optional<Compte> rechercherParEmail(String email) {
		try {
			Optional<Compte> opt = Optional
					.ofNullable(em.createQuery("SELECT c FROM Compte c WHERE c.email=:email ", Compte.class)
							.setParameter("email", email).getSingleResult());
			return opt;
		} catch (NoResultException ex) {
			System.out.println(ex);
		}
		return Optional.empty();
	}

}
