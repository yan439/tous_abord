package fr.isika.cda.projet3.entity.services;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Justificatif {

	@Id
	@GeneratedValue
	private Long id;
	
	private boolean permisDeConduire;
	private boolean certificatDImmatricalation;
	private boolean assurance;
	private boolean controleTechnique;
	
	public Justificatif() {
	}

	public boolean isPermisDeConduire() {
		return permisDeConduire;
	}

	public void setPermisDeConduire(boolean permisDeConduire) {
		this.permisDeConduire = permisDeConduire;
	}

	public boolean isCertificatDImmatricalation() {
		return certificatDImmatricalation;
	}

	public void setCertificatDImmatricalation(boolean certificatDImmatricalation) {
		this.certificatDImmatricalation = certificatDImmatricalation;
	}

	public boolean isAssurance() {
		return assurance;
	}

	public void setAssurance(boolean assurance) {
		this.assurance = assurance;
	}

	public boolean isControleTechnique() {
		return controleTechnique;
	}

	public void setControleTechnique(boolean controleTechnique) {
		this.controleTechnique = controleTechnique;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assurance, certificatDImmatricalation, controleTechnique, permisDeConduire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this.equals(obj))
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		Justificatif other = (Justificatif) obj;
		return assurance == other.assurance && certificatDImmatricalation == other.certificatDImmatricalation
				&& controleTechnique == other.controleTechnique && permisDeConduire == other.permisDeConduire;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Justificatif [id=");
		builder.append(id);
		builder.append(", permisDeConduire=");
		builder.append(permisDeConduire);
		builder.append(", certificatDImmatricalation=");
		builder.append(certificatDImmatricalation);
		builder.append(", assurance=");
		builder.append(assurance);
		builder.append(", controleTechnique=");
		builder.append(controleTechnique);
		builder.append("]");
		return builder.toString();
	}
	
		
}
