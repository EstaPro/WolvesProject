package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@SuppressWarnings("serial")
@Entity
public class Utilisateur implements Serializable{

	@Id
	@GeneratedValue
	private Long id_user;
	@Column(name="NOM",length=30)
	@NotEmpty
	private String nom;
	@NotEmpty
	private String prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;
	@NotEmpty
	private String cin;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String telephone;
	private String login;
	private String password;
	private Boolean active;

	public Utilisateur(){

	}

	public Utilisateur(String nom, Date date_naissance, String cin, String email, String telephone, String login,
			String password, Boolean active) {
		super();
		this.nom = nom;
		this.date_naissance = date_naissance;
		this.cin = cin;
		this.email = email;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public void finalize() throws Throwable {

	}
	
	public Long getId_user() {
		return id_user;
	}
	
	public void setId_user(Long id_user) {
		this.id_user=id_user;
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

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", cin=" + cin
				+ ", email=" + email + ", telephone=" + telephone + ", login=" + login + ", password=" + password
				+ ", active=" + active + "]";
	}

}