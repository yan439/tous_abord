package fr.isika.cda.projet3.entity.utilisateurs;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Contributeur extends Utilisateur {

}
