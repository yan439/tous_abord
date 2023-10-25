package fr.isika.cda.projet3.entity.services;



import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PreuveActeTransport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	TypeService typeService;
	
	
	private Date dateDeDebut;
	

	private Date dateDeFin;

	public PreuveActeTransport() {
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Date getDateDeDebut() {
		return dateDeDebut;
	}

	public void setDateDeDebut(Date dateDeDebut) {
		this.dateDeDebut = dateDeDebut;
	}

	public Date getDateDeFin() {
		return dateDeFin;
	}

	public void setDateDeFin(Date dateDeFin) {
		this.dateDeFin = dateDeFin;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDeDebut, dateDeFin, typeService);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		PreuveActeTransport other = (PreuveActeTransport) obj;
		return Objects.equals(dateDeDebut, other.dateDeDebut) && Objects.equals(dateDeFin, other.dateDeFin)
				&& typeService.equals(other.typeService);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PreuveActeTransport [id=");
		builder.append(id);
		builder.append(", typeService=");
		builder.append(typeService);
		builder.append(", dateDeDebut=");
		builder.append(dateDeDebut);
		builder.append(", dateDeFin=");
		builder.append(dateDeFin);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
