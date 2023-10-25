package fr.isika.cda.projet3.entity.utilisateurs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String telephone;

	
	
	
	
	
	public Contact() {
		super();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	

	public Long getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=");
		builder.append(id);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append("]");
		return builder.toString();
	}

	
}
