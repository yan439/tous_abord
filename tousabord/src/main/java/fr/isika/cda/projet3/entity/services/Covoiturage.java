package fr.isika.cda.projet3.entity.services;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Covoiturage extends Service {

	private int nombreDePassagers;
	
	public Covoiturage() {
	}


	public int getNombreDePassagers() {
		return nombreDePassagers;
	}


	public void setNombreDePassagers(int nombreDePassagers) {
		this.nombreDePassagers = nombreDePassagers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Covoiturage [nombreDePassagers=");
		builder.append(nombreDePassagers);
		builder.append("]");
		return builder.toString();
	}


	
	
	

}
