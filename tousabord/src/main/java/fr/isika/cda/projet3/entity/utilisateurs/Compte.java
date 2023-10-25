package fr.isika.cda.projet3.entity.utilisateurs;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import fr.isika.cda.projet3.entity.paiements.MoyenDePaiement;

@Entity
public class Compte {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 180, unique = true)
	private String email;
	
	private String motDePasse;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal solde;
	
	private LocalDate dateDeCreation;
	
	private LocalTime heureDeCreation;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeModification;
	
	@Temporal(TemporalType.DATE)
	private Date dateDeSuppression;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany
	private List<MoyenDePaiement> moyenDePaiement = new ArrayList<MoyenDePaiement>();

	@OneToMany
	private List<Message> messages = new ArrayList<>();
	
	
	public Compte() {
		dateDeCreation = LocalDate.now();
		heureDeCreation = LocalTime.now();
	}

	public List<MoyenDePaiement> getMoyenDePaiement() {
		return moyenDePaiement;
	}
	
	public void setMoyenDePaiement(List<MoyenDePaiement> moyenDePaiement) {
		this.moyenDePaiement = moyenDePaiement;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public BigDecimal getSolde() {
		return solde;
	}

	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}

	public Date getDateDeModification() {
		return dateDeModification;
	}

	public LocalDate getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(LocalDate dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public LocalTime getHeureDeCreation() {
		return heureDeCreation;
	}

	public void setHeureDeCreation(LocalTime heureDeCreation) {
		this.heureDeCreation = heureDeCreation;
	}

	public void setDateDeModification(Date dateDeModification) {
		this.dateDeModification = dateDeModification;
	}

	public Date getDateDeSuppression() {
		return dateDeSuppression;
	}

	public void setDateDeSuppression(Date dateDeSuppression) {
		this.dateDeSuppression = dateDeSuppression;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", solde=");
		builder.append(solde);
		builder.append(", dateDeCreation=");
		builder.append(dateDeCreation);
		builder.append(", dateDeModification=");
		builder.append(dateDeModification);
		builder.append(", dateDeSuppression=");
		builder.append(dateDeSuppression);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}


