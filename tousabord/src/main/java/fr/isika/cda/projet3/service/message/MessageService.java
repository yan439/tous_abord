package fr.isika.cda.projet3.service.message;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.utilisateurs.Message;
import fr.isika.cda.projet3.repository.message.IMessageRepository;
import fr.isika.cda.projet3.repository.utilisateurs.IUtilisateurRepository;

@Stateless
public class MessageService implements IMessageService {
	
	@Inject
	private IMessageRepository messageRepository;

	@Override
	public void creer(Message message) {
		messageRepository.creer(message);
	}

	@Override
	public void modifier(Message message) {
		messageRepository.modifier(message);
	}

	@Override
	public void supprimer(Long id) {
		messageRepository.supprimer(id);
	}

	@Override
	public Optional<Message> rechercherParId(Long id) {
		return messageRepository.rechercherParId(id);
	}

	@Override
	public List<Message> rechercherTout() {
		return messageRepository.rechercherTout();
	}

	
	@Override
	public Message trouverMessageDansListeParId(List<Message> messages, Long idMessage) {
	    return messages.stream().filter(message -> idMessage.equals(message.getId())).findFirst().orElse(null);
	}


}
