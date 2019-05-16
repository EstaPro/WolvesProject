package ma.rfidmaroc.patrolmanager.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.rfidmaroc.patrolmanager.entities.Tag;


public interface TagRepository extends JpaRepository<Tag, Long>{

	@Query("from Tag t where t.contenu like :mc")
	public List<Tag> chercherTags(@Param("mc")String mc);
	
}
