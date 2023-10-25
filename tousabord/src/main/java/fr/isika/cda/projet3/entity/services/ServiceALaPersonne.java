package fr.isika.cda.projet3.entity.services;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ServiceALaPersonne extends Service {

	
	public ServiceALaPersonne() {
	}
	

}
