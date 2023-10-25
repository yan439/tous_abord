package fr.isika.cda.projet3.service.organisation;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Organisation;
import fr.isika.cda.projet3.repository.organisation.IOrganisationRepository;
import fr.isika.cda.projet3.repository.organisation.OrganisationRepository;

@Stateless
public class OrganisationService implements IOrganisationService {

	@Inject
	private IOrganisationRepository organisationRepository;
    
	
	
	public void creer( Organisation organisation) {
		organisationRepository.creer(organisation);

	}

	public void modifier(Organisation organisation) {
	organisationRepository.modifier(organisation);

	}

	@Override
	public void supprimer(Long id) {
		organisationRepository.supprimer(id);

	}

	public IOrganisationRepository getOrganisationRepository() {
		return organisationRepository;
	}

	public void setOrganisationRepository(OrganisationRepository organisationRepository) {
		this.organisationRepository = organisationRepository;
	}

	@Override
	public Optional<Organisation> rechercherParId(Long id) {
		
		return organisationRepository.rechercherParId(id);
	}
     
	
	@Override
	public List<Organisation> rechercherTout() {
	
		return organisationRepository.rechercherTout();
	}

	@Override
	public List<Service> getServices(Long Id) {
	 return  organisationRepository.getServices(Id);
		
	}

	@Override
	public List<Vehicule> getVehicule(Long Id) {
		return organisationRepository.getVehicule(Id);
	}

	@Override
	public List<Don> getDons(Long Id) {
		
		return organisationRepository.getDons(Id);
	}

	

	

	
	

	

		
	}

//     public List<Service>getServices(Long Id){
//	return utilisateurRepository.getServices(Id);
//}
//     public List<Don>getDons(Long Id){
//    		return utilisateurRepository.getDons(Id);
//    	}
//     
//     public List<Vehicule>getVehicules(Long Id){
//    		return utilisateurRepository.getVehicule(Id);
//    	}
     
     
     
	

