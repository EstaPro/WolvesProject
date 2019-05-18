package ma.rfidmaroc.patrolmanager.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.rfidmaroc.patrolmanager.dao.PatrouilleRepository;
import ma.rfidmaroc.patrolmanager.entities.Patrouille;
import ma.rfidmaroc.patrolmanager.models.PatrouilleForm;

@Service
@Transactional
public class PatrouilleServices implements IpatrouilleServices{
	
	@Autowired
	PatrouilleRepository patrouilleRepository;


	@Override
	public Patrouille enregistrerPatrouille(Patrouille p) {
		return patrouilleRepository.save(p);
	}
	
	public Patrouille savePatrouilleFromPatrouilleForm(PatrouilleForm patrouilleForm) {
		Patrouille patrouille = null;
		
					
		patrouille = new Patrouille(patrouilleForm.getNom_patr(),patrouilleForm.getDureeMoyenne_min(),patrouilleForm.getMargeErr_min());
			
		patrouilleRepository.save(patrouille);
		
		return patrouille;
	}
	
	public List<Patrouille> chercherPatrouilles(String mc)
	{
		List<Patrouille> list = new ArrayList<Patrouille>();
		list = patrouilleRepository.chercherPatrouilles("%"+mc+"%");
		return list;
	}

}
