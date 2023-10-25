package fr.isika.cda.projet3.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Statistique {

	@Id
	@GeneratedValue
	private Long id;

	@Column(precision = 12, scale = 2)
	private BigDecimal chiffreDAffaireParJour;

	@Column(precision = 12, scale = 2)
	private BigDecimal chiffreDAffaireParMois;

	@Column(precision = 12, scale = 2)
	private BigDecimal chiffreDAffaireParAn;

	private int nombreFrequentation;

	private int nbreServiceRendu;

	private int nbreDeConflits;

	@Column(precision = 12, scale = 2)
	private BigDecimal bilanEcoCarbone;

	public BigDecimal getChiffreDAffaireParJour() {
		return chiffreDAffaireParJour;
	}

	public void setChiffreDAffaireParJour(BigDecimal chiffreDAffaireParJour) {
		this.chiffreDAffaireParJour = chiffreDAffaireParJour;
	}

	public BigDecimal getChiffreDAffaireParMois() {
		return chiffreDAffaireParMois;
	}

	public void setChiffreDAffaireParMois(BigDecimal chiffreDAffaireParMois) {
		this.chiffreDAffaireParMois = chiffreDAffaireParMois;
	}

	public BigDecimal getChiffreDAffaireParAn() {
		return chiffreDAffaireParAn;
	}

	public void setChiffreDAffaireParAn(BigDecimal chiffreDAffaireParAn) {
		this.chiffreDAffaireParAn = chiffreDAffaireParAn;
	}

	public int getNombreFrequentation() {
		return nombreFrequentation;
	}

	public void setNombreFrequentation(int nombreFrequentation) {
		this.nombreFrequentation = nombreFrequentation;
	}

	public int getNbreServiceRendu() {
		return nbreServiceRendu;
	}

	public void setNbreServiceRendu(int nbreServiceRendu) {
		this.nbreServiceRendu = nbreServiceRendu;
	}

	public int getNbreDeConflits() {
		return nbreDeConflits;
	}

	public void setNbreDeConflits(int nbreDeConflits) {
		this.nbreDeConflits = nbreDeConflits;
	}

	public BigDecimal getBilanEcoCarbone() {
		return bilanEcoCarbone;
	}

	public void setBilanEcoCarbone(BigDecimal bilanEcoCarbone) {
		this.bilanEcoCarbone = bilanEcoCarbone;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Statistique [id=");
		builder.append(id);
		builder.append(", chiffreDAffaireParJour=");
		builder.append(chiffreDAffaireParJour);
		builder.append(", chiffreDAffaireParMois=");
		builder.append(chiffreDAffaireParMois);
		builder.append(", chiffreDAffaireParAn=");
		builder.append(chiffreDAffaireParAn);
		builder.append(", nombreFrequentation=");
		builder.append(nombreFrequentation);
		builder.append(", nbreServiceRendu=");
		builder.append(nbreServiceRendu);
		builder.append(", nbreDeConflits=");
		builder.append(nbreDeConflits);
		builder.append(", bilanEcoCarbone=");
		builder.append(bilanEcoCarbone);
		builder.append("]");
		return builder.toString();
	}

}
