package fr.isika.cda.projet3.entity.utilisateurs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Avis {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dateAvis;
	
	@Lob
	private String commentaire;
	
	private int note;	
	
	public Avis() {
		super();
	}
	
	public Date getDateAvis() {
		return dateAvis;
	}
	public void setDateAvis(Date dateAvis) {
		this.dateAvis = dateAvis;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avis [id=");
		builder.append(id);
		builder.append(", dateAvis=");
		builder.append(dateAvis);
		builder.append(", commentaire=");
		builder.append(commentaire);
		builder.append(", note=");
		builder.append(note);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
