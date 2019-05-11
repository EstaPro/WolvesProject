package ma.rfidmaroc.patrolmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Administrateur;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
	
	@Query("from Administrateur a where a.cin like :mc")
	public List<Administrateur> chercherAdministrateurs(@Param("mc")String mc);

}
