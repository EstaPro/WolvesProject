package ma.rfidmaroc.patrolmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Patrouilleur;

public interface PatrouilleurRepository extends JpaRepository<Patrouilleur, Long>{
	
	@Query("select p from Patrouilleur p where p.cin like :mc")
	public List<Patrouilleur> chercherPatrouilleurs(@Param(value="mc")String mc);

}
