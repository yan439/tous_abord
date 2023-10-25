package fr.isika.cda.projet3.repository.transactions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.isika.cda.projet3.entity.paiements.Transaction;
import fr.isika.cda.projet3.entity.services.Location;
import fr.isika.cda.projet3.repository.location.ILocationRepository;

@Stateless
public class TransactionRepository implements ITransactionRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Transaction creer(Transaction transaction) {
		//transaction.setMontant(crypterDonnee(transaction.getMontant()));
		em.persist(transaction);
		return transaction;
	}
	
	@Override
	public void modifier(Transaction transaction) {
		em.merge(transaction);
	}
	
	@Override
	public void supprimer(Long id) {
		Optional<Transaction> opt = rechercherParId(id);
		if(opt.isPresent()) {
			em.remove(opt.get());
		}
	}
	
	@Override
	public Optional<Transaction> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Transaction.class, id));
	}
	
	@Override
	public List<Transaction> rechercherTout() {
        return em.createQuery("select t from Transaction t", Transaction.class).getResultList();
    }
	
//	public static String crypterDonnee(String donneeACrypter) {
//		
//		String donneeCryptee = "";
//		
//		try {
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			md.update(donneeACrypter.getBytes());
//			byte[] bytes = md.digest();
//			StringBuilder sb = new StringBuilder();  
//            for (int i = 0; i < bytes.length; i++) {  
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
//            }
//            donneeCryptee = sb.toString();
//            
//		} catch (NoSuchAlgorithmException e) {  
//            System.out.println(e);  
//        }
//		
//		return donneeCryptee;
//	}
	
}
