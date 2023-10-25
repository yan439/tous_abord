package fr.isika.cda.projet3.entity.services;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Location extends Service {
	
	
	public Location() {
	}
	

}
