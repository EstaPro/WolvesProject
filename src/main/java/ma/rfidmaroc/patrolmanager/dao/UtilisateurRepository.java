package ma.rfidmaroc.patrolmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
