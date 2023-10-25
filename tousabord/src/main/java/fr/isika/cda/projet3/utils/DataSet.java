package fr.isika.cda.projet3.utils;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projet3.entity.utilisateurs.Adresse;
import fr.isika.cda.projet3.entity.utilisateurs.Compte;
import fr.isika.cda.projet3.entity.utilisateurs.InfosPersonnelles;
import fr.isika.cda.projet3.entity.utilisateurs.Message;
import fr.isika.cda.projet3.entity.utilisateurs.Role;
import fr.isika.cda.projet3.entity.utilisateurs.Utilisateur;

@Singleton
@Startup
public class DataSet {
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	private void initData() {
//		Adresse depart = new Adresse();
//		depart.setCodePostal("75005");
//
//		Adresse arrive = new Adresse();
//		arrive.setCodePostal("40100");
//
//		InfoDebutService ids = new InfoDebutService();
//		ids.setLieuDeDepart(depart);
//
//		InfoFinService ifs = new InfoFinService();
//		ifs.setLieuDArrivee(arrive);
//
//		Service service = new Service();
//
//		service.setMontant(new BigDecimal(20.55));
//
//		service.setNomduService(TypeService.COVOITURAGE);
//
//		service.setInfoDebutService(ids);
//
//		service.setInfoFinService(ifs);
//
//		em.persist(service);
//
//		// 1 - création des relations

		Adresse a = new Adresse();
		a.setVille("Paris");

		InfosPersonnelles ip = new InfosPersonnelles();
		ip.setNom("Hamid");
		ip.setImagePath("/img/utilisateur/users.png");

		Compte c = new Compte();
		c.setEmail("admin@admin.com");
		c.setMotDePasse("1234");
		c.setRole(Role.ADMIN);
		c.setSolde(new BigDecimal("2000"));
	


//		// creation d'une organisation 
//		Adresse orgAdd1 = new Adresse();
//		orgAdd1.setNumero(1);
//		orgAdd1.setVoie("rue de paris");
//		orgAdd1.setCodePostal("75000");
//		
//		Service serOrg1=new Service();
//		serOrg1.setNomduService(TypeService.LOCATION);
//		serOrg1.setInfoDebutService(ids);
//		
//		Organisation org1= new Organisation();
//		org1.setNumeroSiren(111);
//		org1.setRaisonSociale("ORG1");
//		org1.setImagePath("/img/organisation/org1.jpg");
//		org1.setAdresse(orgAdd1);
//		
//		em.persist(org1);
		
		// 2 - création de l'entité "conteneur" (celle qui contient les relations)
		Utilisateur hamid = new Utilisateur();

		// 3 association des relations
		hamid.setInfoPersonnelle(ip);
		hamid.setAdresse(a);
		hamid.setCompte(c);

		// sauvegarde (avec cascade donc on save que l'entité conteneur)
		// sans cascade on save d'abord les relations (compte, infos, adresse ...)
		// ensuite l'entité conteneur
    	em.persist(hamid);
//
//		// persistance véhicule et Justificatif
//
//		Justificatif j = new Justificatif();
//		j.setAssurance(true);
//		j.setCertificatDImmatricalation(true);
//
//		Vehicule v = new Vehicule();
//		v.setMarque("Peujeot");
//		v.setJustificatif(j);
//		
//		hamid.addVehicule(v);
//		
//		em.persist(v);
//
//		// persistance classe service et de ses sous classes
//		Covoiturage covoiturage = new Covoiturage();
//		covoiturage.setNombreDePassagers(3);
//		covoiturage.setMontant(new BigDecimal(22));
//		covoiturage.setNomduService(TypeService.COVOITURAGE);
//		
//		hamid.addService(covoiturage);
//		
//		em.persist(covoiturage);
//
//		Location location = new Location();
//		em.persist(location);
//
//		Livraison livraison = new Livraison();
//		em.persist(livraison);
//
//		// persistance classe PreuveActeTransport
//		PreuveActeTransport p = new PreuveActeTransport();
//		p.setTypeService(TypeService.LOCATION);
//		// p.setDateDeDebut(new Date("2022-08-22"));
//		p.setDateDeFin(new Date(2022, 8, 22, 23, 59));
//		em.persist(p);
//
//		// Persistance de la classe reservation
//		Reservation r = new Reservation();
//		r.setEtatReservation(EtatReservation.EN_ATTENTE);
//		// r.setDateReservation(new Date(2022, 8, 22));
//		em.persist(r);
//		
		// Persistance d'un compte pour tester la connexion
		Utilisateur utilisateur = new Utilisateur();
		InfosPersonnelles infosPersonnelles = new InfosPersonnelles();
		infosPersonnelles.setNom("Sourigues");
		infosPersonnelles.setPrenom("Yannick");
		utilisateur.setInfoPersonnelle(infosPersonnelles);
		Compte compteTest = new Compte();
		compteTest.setEmail("toto@tutu.fr");
		compteTest.setMotDePasse("1234");
		compteTest.setSolde(new BigDecimal("200"));
		compteTest.setRole(Role.UTILISATEUR);
		utilisateur.setCompte(compteTest);
		em.persist(utilisateur);
		
		Utilisateur utilisateurA = new Utilisateur();
		InfosPersonnelles infosA = new InfosPersonnelles();
		infosA.setNom("a");
		infosA.setPrenom("a");
		utilisateurA.setInfoPersonnelle(infosA);
		List<Message> messages = utilisateurA.getMessages();
		Message msg1 = new Message();
		msg1.setObjetDuMessage("msg1");
		msg1.setCorpsDuMessage("test1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Message msg2 = new Message();
		msg2.setObjetDuMessage("msg2");
		msg2.setCorpsDuMessage("test2...................");
		messages.add(msg1);
		messages.add(msg2);
		utilisateurA.setMessages(messages);
		Compte compteA = new Compte();
		compteA.setEmail("a@a.fr");
		compteA.setMotDePasse("a");
		compteA.setSolde(new BigDecimal("100"));
		compteA.setRole(Role.UTILISATEUR);
		utilisateurA.setCompte(compteA);
		em.persist(utilisateurA);
		
		// Persistance d'un Admin

//		Utilisateur admin = new Utilisateur();
//		InfosPersonnelles infosAdmin = new InfosPersonnelles();
//		infosAdmin.setNom("Admin");
//		infosAdmin.setPrenom("admin");
//		admin.setInfoPersonnelle(infosAdmin);
//		Compte compteAdmin = new Compte();
//		compteAdmin.setEmail("admin@admin.fr");
//		compteAdmin.setMotDePasse("1234");
//		compteAdmin.setSolde(new BigDecimal("2000"));
//		compteAdmin.setRole(Role.ORGANISATION);
//		admin.setCompte(compteAdmin);
//		em.persist(admin);

	
//		Don don = new Don();
//		don.setDateDuDon(new Date());
//		don.setMontant(BigDecimal.valueOf(10.0));
//		don.setPrenomDuDonateur("Hamid");
//		don.setNomDuDonateur("H");
//		
//		hamid.addDon(don);
//		em.persist(don);
		
		
		
		
	}
}