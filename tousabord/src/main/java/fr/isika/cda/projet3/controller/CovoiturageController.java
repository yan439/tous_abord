package fr.isika.cda.projet3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.projet3.entity.services.Covoiturage;
import fr.isika.cda.projet3.service.covoiturage.ICovoiturageService;


@ManagedBean
public class CovoiturageController {

	@Inject
	private ICovoiturageService covoiturageService;
	
	
	private Covoiturage covoiturage = new Covoiturage();
	
	private List<Covoiturage> covoiturages = new ArrayList<>();
	
	
	public String creerCovoiturage() {
		System.out.println(covoiturage.getNomduService() + " " + covoiturage.getInfoDebutService() + " " + covoiturage.getInfoFinService()) ;
	
		
		covoiturageService.creer(covoiturage);
		
		System.out.println(covoiturage);
		
		return "index.xhtml";
	}
	
}
