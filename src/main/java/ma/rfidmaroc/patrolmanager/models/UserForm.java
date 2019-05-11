package ma.rfidmaroc.patrolmanager.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserForm {

	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date date_naissance;
	@NotEmpty
	private String cin;
	@Email
	private String email;
	@Size(min = 10, max = 10)
	@NotEmpty
	private String telephone;
	@NotEmpty
	private String login;
	@Size(min=3, max=30)
	private String password;
	private Boolean active;
	@NotEmpty
	@Size(min = 4, max = 5)
	String role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	private int page = 0;
	private int nbLignes = 10;
	private int nombrePages;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}

	public int getNombrePages() {
		return nombrePages;
	}

	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserForm [nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", cin=" + cin
				+ ", email=" + email + ", telephone=" + telephone + ", login=" + login + ", password=" + password
				+ ", active=" + active + ", role=" + role + ", page=" + page + ", nbLignes=" + nbLignes
				+ ", nombrePages=" + nombrePages + "]";
	}
	
	

}
