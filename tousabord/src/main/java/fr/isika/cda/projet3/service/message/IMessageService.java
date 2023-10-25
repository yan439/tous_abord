package fr.isika.cda.projet3.service.message;

import java.util.List;

import fr.isika.cda.projet3.entity.utilisateurs.Message;
import fr.isika.cda.projet3.service.IService;

public interface IMessageService extends IService<Message> {


	Message trouverMessageDansListeParId(List<Message> messages, Long idMessage);

}
