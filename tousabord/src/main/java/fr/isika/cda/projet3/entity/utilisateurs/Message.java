package fr.isika.cda.projet3.entity.utilisateurs;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Message {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long idExpediteur;

	private LocalDate dateDEnvoi;

	private LocalTime heureDEnvoi;

	private String destinataire;

	private String objetDuMessage;

	@Lob
	private String corpsDuMessage;

	private String etatCoteExpediteur;

	private String etatCoteDestinataire;
	
	public Message() {
		dateDEnvoi = LocalDate.now();
		heureDEnvoi = LocalTime.now();
		etatCoteExpediteur = "Envoyé";
		etatCoteDestinataire = "Non lu";
	}

	public String getDestinataire() {
		return destinataire;
	}

	public LocalDate getDateDEnvoi() {
		return dateDEnvoi;
	}

	public void setDateDEnvoi(LocalDate dateDEnvoi) {
		this.dateDEnvoi = dateDEnvoi;
	}

	public LocalTime getHeureDEnvoi() {
		return heureDEnvoi;
	}

	public void setHeureDEnvoi(LocalTime heureDEnvoi) {
		this.heureDEnvoi = heureDEnvoi;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getObjetDuMessage() {
		return objetDuMessage;
	}

	public void setObjetDuMessage(String objetDuMessage) {
		this.objetDuMessage = objetDuMessage;
	}

	public String getCorpsDuMessage() {
		return corpsDuMessage;
	}

	public void setCorpsDuMessage(String corpsDuMessage) {
		this.corpsDuMessage = corpsDuMessage;
	}

	public String getEtatCoteExpediteur() {
		return etatCoteExpediteur;
	}

	public void setEtatCoteExpediteur(String etatCoteExpediteur) {
		this.etatCoteExpediteur = etatCoteExpediteur;
	}

	public String getEtatCoteDestinataire() {
		return etatCoteDestinataire;
	}

	public void setEtatCoteDestinataire(String etatCoteDestinataire) {
		this.etatCoteDestinataire = etatCoteDestinataire;
	}

	public Long getId() {
		return id;
	}
	
	public Long getIdExpediteur() {
		return idExpediteur;
	}
	
	public void setIdExpediteur(Long idExpediteur) {
		this.idExpediteur = idExpediteur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", dateDEnvoi=");
		builder.append(dateDEnvoi);
		builder.append(", heureDEnvoi=");
		builder.append(heureDEnvoi);
		builder.append(", destinataire=");
		builder.append(destinataire);
		builder.append(", objetDuMessage=");
		builder.append(objetDuMessage);
		builder.append(", corpsDuMessage=");
		builder.append(corpsDuMessage);
		builder.append(", etatCoteExpediteur=");
		builder.append(etatCoteExpediteur);
		builder.append(", etatCoteDestinataire=");
		builder.append(etatCoteDestinataire);
		builder.append("]");
		return builder.toString();
	}

}
