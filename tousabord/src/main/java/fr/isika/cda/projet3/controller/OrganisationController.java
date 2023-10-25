package fr.isika.cda.projet3.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.projet3.entity.utilisateurs.Organisation;
import fr.isika.cda.projet3.service.organisation.IOrganisationService;
import fr.isika.cda.projet3.utils.FileUpload;

	
	@ManagedBean
	@ViewScoped
	
	
	
 public class OrganisationController implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		@Inject
		private IOrganisationService organisationService;

		private Organisation organisation= new Organisation();
		
	    private List<Organisation> listeOrganisations = new ArrayList<>();
		
	    
	    public void onLoad() {

			Map<String, String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
			String orgIdStr = map.get("orgId");
			if(orgIdStr != null) {
				Long orgId = Long.valueOf(orgIdStr);
				Optional<Organisation> opt = organisationService.rechercherParId(orgId);
				if (opt.isPresent()) {
					this.organisation = opt.get();
//					this.services = organisationService.getServices(orgId);
//					this.vehicules = organisationService.getVehicule(orgId);
//					this.dons = organisationService.getDons(orgId);
				}
			} else {
				System.err.println("Parameter : orgId not found");
			}
		}
	    
	    
	    public String creerOrganisation() {
	
	
			organisationService.creer(organisation);
		
			System.out.println("Utilisateur créé !");
	        return "creer-organisation.xhtml";
		}
	     
	    @PostConstruct
	    public void init() {
	    	this.listeOrganisations=organisationService.rechercherTout();
	    }
		
	    
	    public void supprimerOrganisation(long id) {
	    	System.out.println(organisation.getId());
	    	organisationService.supprimer(id);
	    }
	    
	    public String modifierOrganisation(Organisation o) {
			this.organisation=o;
			System.out.println(o.getId());
			return "modifier-organisation.xhtml";
		}

		public String modifierOrganisation() {
			organisationService.modifier(organisation);
			//return "profil-organisation?id=" + organisation.getId()+ "faces-redirect=true";
			return "liste-organisation.xhtml";
		}
	    
	    
	    
		public void upload(FileUploadEvent event) {
			UploadedFile file = event.getFile();
			String filePath = "/organisation/" + file.getFileName();
			
			FileUpload.doUpload(file, filePath);
			organisation.setImagePath("/img"+filePath);
		

		}

		

		public Organisation getOrganisation() {
			return organisation;
		}
        public void setListeOrganisations(List<Organisation> listeOrganisations) {
			this.listeOrganisations = listeOrganisations;
		}
		public void setOrganisation(Organisation organisation) {
			this.organisation = organisation;
		}

		public List<Organisation> getListeOrganisations() {
			return listeOrganisations;
		}

		private static Date getTodaysDate() {
			return Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		}
	}


