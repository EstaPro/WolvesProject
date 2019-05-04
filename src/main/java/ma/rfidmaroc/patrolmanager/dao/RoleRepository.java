package ma.rfidmaroc.patrolmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.rfidmaroc.patrolmanager.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
