package fr.isika.cda.projet3.service.organisation;



import java.util.List;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Organisation;
import fr.isika.cda.projet3.service.IService;


public interface IOrganisationService extends IService<Organisation> {

	public List<Service> getServices(Long Id);
	public List<Vehicule> getVehicule(Long Id);
	public List<Don> getDons(Long Id); 
	
}
