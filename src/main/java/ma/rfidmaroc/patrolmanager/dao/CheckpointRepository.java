package ma.rfidmaroc.patrolmanager.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Checkpoint;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

public interface CheckpointRepository extends JpaRepository<Checkpoint, Long>{

	@Query("from Checkpoint c where c.geo_location like :mc")
	public List<Checkpoint> chercherCheckpoints(@Param("mc")String mc);
	
}
