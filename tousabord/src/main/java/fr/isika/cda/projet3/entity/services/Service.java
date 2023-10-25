package fr.isika.cda.projet3.entity.services;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;
import fr.isika.cda.projet3.utils.SessionUtils;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Service {

	@Id
	@GeneratedValue
	protected Long id;
	
	private Long idContributeur;

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private InfoDebutService infoDebutService = new InfoDebutService();

	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	private InfoFinService infoFinService =  new InfoFinService();

	@Enumerated(EnumType.STRING)
	protected TypeService nomduService;

	@Column(precision = 12, scale = 2)
	protected BigDecimal montant;

	@Enumerated(EnumType.STRING)
	protected EtatService etatService;
	
	private String imagePath;
	
	

	public Service() {
		
	}

	public EtatService getEtatService() {
		return etatService;
	}
	
	public void setEtatService(EtatService etatService) {
		this.etatService = etatService;
	}
	
	public InfoDebutService getInfoDebutService() {
		return infoDebutService;
	}

	public void setInfoDebutService(InfoDebutService infoDebutService) {
		this.infoDebutService = infoDebutService;
	}

	public InfoFinService getInfoFinService() {
		return infoFinService;
	}

	public void setInfoFinService(InfoFinService infoFinService) {
		this.infoFinService = infoFinService;
	}

	public TypeService getNomduService() {
		return nomduService;
	}

	public void setNomduService(TypeService nomduService) {
		this.nomduService = nomduService;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Long getId() {
		return id;
	}

	
	public Long getIdContributeur() {
		return idContributeur;
	}
	
	public void setIdContributeur(Long idContributeur) {
		this.idContributeur = idContributeur;
	}


	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public int hashCode() {
		return Objects.hash(etatService, infoDebutService, infoFinService, montant, nomduService);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Service other = (Service) obj;
		return etatService.equals(other.etatService) && Objects.equals(infoDebutService, other.infoDebutService)
				&& Objects.equals(infoFinService, other.infoFinService) && Objects.equals(montant, other.montant)
				&& nomduService.equals(other.nomduService);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Service [id=");
		builder.append(id);
		builder.append(", infoDebutService=");
		builder.append(infoDebutService);
		builder.append(", infoFinService=");
		builder.append(infoFinService);
		builder.append(", nomduService=");
		builder.append(nomduService);
		builder.append(", montant=");
		builder.append(montant);
		builder.append(", etatService=");
		builder.append(etatService);
		builder.append("]");
		return builder.toString();
	}

}
