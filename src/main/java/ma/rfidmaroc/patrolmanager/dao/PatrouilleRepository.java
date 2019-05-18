package ma.rfidmaroc.patrolmanager.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Patrouille;

public interface PatrouilleRepository extends JpaRepository<Patrouille, Long>{

	@Query("from Patrouille p where p.nom_patr like :mc")
	public List<Patrouille> chercherPatrouilles(@Param("mc")String mc);
	
}
