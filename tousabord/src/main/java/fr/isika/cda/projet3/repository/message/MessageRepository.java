package fr.isika.cda.projet3.repository.message;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.utilisateurs.Message;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Stateless
public class MessageRepository implements IMessageRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Message creer(Message message) {
		em.persist(message);
		return message;
	}

	@Override
	public void modifier(Message message) {
		em.merge(message);
	}

	@Override
	public void supprimer(Long id) {
		Optional<Message> opt = rechercherParId(id);
		if (opt.isPresent()) {
			em.remove(opt.get());
		}
	}

	@Override
	public Optional<Message> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Message.class, id));
	}

	@Override
	public List<Message> rechercherTout() {
		return em.createQuery("SELECT m FROM Message m", Message.class).getResultList();
	}

}
