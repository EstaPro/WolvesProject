package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@SuppressWarnings("serial")
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USR", discriminatorType=DiscriminatorType.STRING, length=5)
public abstract class Utilisateur implements Serializable{

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
	private String telephone;
	private String login;
	private String password;
	private Boolean active;
	
	
	@ManyToMany
	@JoinTable(name="user_role")
	@JoinColumn(name="id_user")
	Collection<Role> roles;

	public Utilisateur(){

	}

	public Utilisateur(String nom, String prenom, Date date_naissance, String cin, String telephone, String login,
			String password, Boolean active) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.cin = cin;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", date_naissance=" + date_naissance + ", cin=" + cin
				+ ", telephone=" + telephone + ", login=" + login + ", password=" + password
				+ ", active=" + active + "]";
	}

}