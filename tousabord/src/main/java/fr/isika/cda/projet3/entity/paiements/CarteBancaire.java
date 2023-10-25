package fr.isika.cda.projet3.entity.paiements;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CarteBancaire extends MoyenDePaiement {

	private long numero;

	private int cryptogramme;

	@Temporal(TemporalType.DATE)
	private Date dateDExpiration;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(short cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Date getDateDExpiration() {
		return dateDExpiration;
	}

	public void setDateDExpiration(Date dateDExpiration) {
		this.dateDExpiration = dateDExpiration;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarteBancaire [numero=");
		builder.append(numero);
		builder.append(", cryptogramme=");
		builder.append(cryptogramme);
		builder.append(", dateDExpiration=");
		builder.append(dateDExpiration);
		builder.append("]");
		return builder.toString();
	}

}
