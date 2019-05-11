package ma.rfidmaroc.patrolmanager.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("from Utilisateur u where u.cin like :mc")
	public List<Utilisateur> chercherUtilisateurs(@Param("mc")String mc);

//	@Query("select u from Utilisateur u where u.roles.roleLibelle=:role and u.cin like :mc")
//	public List<Utilisateur> chercherUtilisateur(@Param("mc")String cin, @Param("role")String role);
}
