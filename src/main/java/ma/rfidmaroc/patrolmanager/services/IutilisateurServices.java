package ma.rfidmaroc.patrolmanager.services;

import java.util.List;

import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

public interface IutilisateurServices {

	public Utilisateur enregistrerUtilisateur(Utilisateur u);
	public List<Utilisateur> chercherUtilisateurs(String mc, String role);
	
}
