package paypal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda.projet3.entity.paiements.MoyenDePaiement;


@PrimaryKeyJoinColumn(name = "id")
public class PayPal extends MoyenDePaiement {

}

