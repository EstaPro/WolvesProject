package ma.rfidmaroc.patrolmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.rfidmaroc.patrolmanager.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}
