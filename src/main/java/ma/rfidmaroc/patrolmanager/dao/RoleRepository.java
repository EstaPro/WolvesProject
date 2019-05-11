package ma.rfidmaroc.patrolmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.rfidmaroc.patrolmanager.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	List<Role> findByIdRole(Long id_role);
	List<Role> findByRoleLibelle(String role_libelle);

}
