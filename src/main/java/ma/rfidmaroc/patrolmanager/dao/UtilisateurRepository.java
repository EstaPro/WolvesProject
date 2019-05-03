package ma.rfidmaroc.patrolmanager.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("select u from Utilisateur u where u.nom like :X")
	public Page<Utilisateur> chercherUtilisateurs(@Param("X")String mc,Pageable pageable);
}
