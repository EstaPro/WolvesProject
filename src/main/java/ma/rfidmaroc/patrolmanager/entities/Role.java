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
	private Long idRole;
	private String roleLibelle;

	@ManyToMany(mappedBy = "roles")
	private Collection<Utilisateur> users;

	public Role() {
	}

	public Role(String role_libelle) {
		super();
		this.roleLibelle = role_libelle;
	}

	public Long getId_role() {
		return idRole;
	}

	public void setId_role(Long id_role) {
		this.idRole = id_role;
	}

	public String getRoleLibelle() {
		return roleLibelle;
	}

	public void setRole_libelle(String role_libelle) {
		this.roleLibelle = role_libelle;
	}

	public Collection<Utilisateur> getUser() {
		return users;
	}

	public void setUser(Collection<Utilisateur> users) {
		this.users = users;
	}

}
