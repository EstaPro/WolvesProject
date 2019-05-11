package ma.rfidmaroc.patrolmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Long>{
	
	@Query("from Responsable u where u.cin like :mc")
	public List<Responsable> chercherResponsables(@Param("mc")String mc);

}
