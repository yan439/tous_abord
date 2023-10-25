package fr.isika.cda.projet3.entity.services;

public enum TypeService {
	COVOITURAGE("covoiturage"), TRANSPORT_COLIS("transport_colis"), LOCATION("location"), AIDE_A_LA_PERSONNE("aide_a_la_personne");
	
	private String label;
	
	private TypeService(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}


	
}
