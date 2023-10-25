package fr.isika.cda.projet3.repository.organisation;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysql.cj.xdevapi.UpdateType;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Organisation;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Stateless
public class OrganisationRepository implements IOrganisationRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Organisation creer(Organisation organisation) {
		
		em.persist(organisation);
		return organisation;
	}

	@Override
	public void modifier(Organisation organisation ) {
	em.merge(organisation);
	}
 
	@Override
	public void supprimer(Long id) {
		Optional<Organisation> opt = rechercherParId(id);
		if(opt.isPresent()) {
			em.remove(opt.get());
		}
	}
	
	@Override
	public Optional<Organisation> rechercherParId(Long id) {
		return Optional.ofNullable(em.find(Organisation.class, id));
	}

	@Override
	public List<Organisation> rechercherTout() {
		return em.createQuery("select o from Organisation o", Organisation.class).getResultList();
	}
   
	public List<Don>getDons (Long Id){
		String query = "SELECT o FROM Organisation o JOIN FETCH o.dons WHERE o.id=:id";
		Organisation org = em.createQuery(query, Organisation.class).setParameter("id", Id).getSingleResult();
		return org.getDons();
	}
	
	
	public List<Service>getServices (Long Id){
		String query = "SELECT o FROM Organisation o JOIN FETCH o.service WHERE o.id=:id";
		Organisation org = em.createQuery(query, Organisation.class).setParameter("id", Id).getSingleResult();
		return org.getServices();
	}

	public List<Vehicule>getVehicule (Long Id){
		String query = "SELECT o FROM Organisation o JOIN FETCH o.vehicule WHERE o.id=:id";
		Organisation org = em.createQuery(query, Organisation.class).setParameter("id", Id).getSingleResult();
		return org.getVehicules();
	}

	

	
     
     

}
