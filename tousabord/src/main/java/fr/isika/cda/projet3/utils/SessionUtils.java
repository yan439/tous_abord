package fr.isika.cda.projet3.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.isika.cda.projet3.entity.utilisateurs.Compte;

public final class SessionUtils {

	private static final String COMPTE_ID = "Id";
	private static final String UTILISATEUR_ID = "utilisateurId";
	private static final String ROLE = "role";
	private static final SessionUtils INSTANCE = new SessionUtils();
	
	private SessionUtils() {
	}
	
	public static SessionUtils getInstance() {
		return INSTANCE;
	}
	
	
	
	public static void updateSessionImage(String imagePath) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("Image", imagePath);
	}
	
	public static HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session;
	}
	
	public static void setCompteConnecte(Compte compte) {
		HttpSession session = getSession();
		session.setAttribute(COMPTE_ID, compte.getId());
		session.setAttribute("Email", compte.getEmail());
		session.setAttribute(ROLE, compte.getRole().toString());
	}
	
	public static String getEmailCompteConnecte() {
		HttpSession session = getSession();
		return (String) session.getAttribute("Email");
	}
	
	public static boolean estConnecte() {
		return getIdCompteConnecte() != null && !getIdCompteConnecte().isBlank() && 
				getEmailCompteConnecte() != null && !getEmailCompteConnecte().isBlank();
	}

	public static void resetSession() {
		HttpSession session = getSession();
		session.invalidate();
	}
	
	private static String getIdCompteConnecte() {// public ?? hamid
		HttpSession session = getSession();
		Long id = (Long) session.getAttribute(COMPTE_ID);
		return String.valueOf(id);
	}
	
	public static Long getUtilisateurId() {
		HttpSession session = getSession();
		return (Long) session.getAttribute(UTILISATEUR_ID);
	}

	public static void setUtilisateurConnecte(Long id) {
		HttpSession session = getSession();
		session.setAttribute(UTILISATEUR_ID, id);
	}
	
	public static String getRole() {
		HttpSession session = getSession();
		String role = (String) session.getAttribute(ROLE);
		return role;
	}
	
}
