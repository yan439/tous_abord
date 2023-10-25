package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.paiements.Don;
import fr.isika.cda.projet3.entity.services.Service;
import fr.isika.cda.projet3.entity.services.Vehicule;
import fr.isika.cda.projet3.entity.utilisateurs.Organisation;
import fr.isika.cda.projet3.service.organisation.IOrganisationService;

@ViewScoped
@ManagedBean
public class OrganisationProfilController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private IOrganisationService organisationService;

	private Organisation organisation;
	private List<Service> services = new ArrayList<>();
	private List<Vehicule> vehicules = new ArrayList<>();
	private List<Don> dons = new ArrayList<>();
	
	public void onLoad() {

		Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String orgIdStr = map.get("orgId");
		if(orgIdStr != null) {
			Long orgId = Long.valueOf(orgIdStr);
			
			Optional<Organisation> opt = organisationService.rechercherParId(orgId);
			if (opt.isPresent()) {
				this.organisation = opt.get();
//				this.services = organisationService.getServices(orgId);
//				this.vehicules = organisationService.getVehicule(orgId);
//				this.dons = organisationService.getDons(orgId);
			}
		} else {
			System.err.println("Parameter : orgId not found");
		}
	}
	
	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public List<Don> getDons() {
		return dons;
	}

	public void setDons(List<Don> dons) {
		this.dons = dons;
	}
}
