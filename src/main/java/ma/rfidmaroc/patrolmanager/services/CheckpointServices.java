package ma.rfidmaroc.patrolmanager.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.rfidmaroc.patrolmanager.dao.CheckpointRepository;
import ma.rfidmaroc.patrolmanager.entities.Administrateur;
import ma.rfidmaroc.patrolmanager.entities.Checkpoint;
import ma.rfidmaroc.patrolmanager.entities.Responsable;
import ma.rfidmaroc.patrolmanager.entities.Role;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;
import ma.rfidmaroc.patrolmanager.models.CheckpointForm;
import ma.rfidmaroc.patrolmanager.models.UserForm;

@Service
@Transactional
public class CheckpointServices implements IcheckpointServices{
	
	@Autowired
	CheckpointRepository checkpointRepository;


	@Override
	public Checkpoint enregistrerCheckpoint(Checkpoint c) {
		return checkpointRepository.save(c);
	}
	
	public Checkpoint saveCheckpointFromCheckpointForm(CheckpointForm checkpointForm) {
		Checkpoint checkpoint = null;
		
					
			checkpoint = new Checkpoint(checkpointForm.getGeo_location());
			
			checkpointRepository.save(checkpoint);
		
		return checkpoint;
	}
	
	public List<Checkpoint> chercherCheckpoints(String mc)
	{
		List<Checkpoint> list = new ArrayList<Checkpoint>();
		list = checkpointRepository.chercherCheckpoints("%"+mc+"%");
		return list;
	}

}
