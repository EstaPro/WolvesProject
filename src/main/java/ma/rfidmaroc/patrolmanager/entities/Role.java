package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

	@Id
	@GeneratedValue
	private Long id_role;
	private String role_libelle;

	@ManyToMany(mappedBy = "roles")
	private Collection<Utilisateur> users;

	public Role() {
	}

	public Role(String role_libelle) {
		super();
		this.role_libelle = role_libelle;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public String getRole_libelle() {
		return role_libelle;
	}

	public void setRole_libelle(String role_libelle) {
		this.role_libelle = role_libelle;
	}

	public Collection<Utilisateur> getUser() {
		return users;
	}

	public void setUser(Collection<Utilisateur> users) {
		this.users = users;
	}

}
