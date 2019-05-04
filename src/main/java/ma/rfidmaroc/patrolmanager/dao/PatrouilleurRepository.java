package ma.rfidmaroc.patrolmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.rfidmaroc.patrolmanager.entities.Patrouilleur;

public interface PatrouilleurRepository extends JpaRepository<Patrouilleur, Long>{

}
