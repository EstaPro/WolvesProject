package ma.rfidmaroc.patrolmanager.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.rfidmaroc.patrolmanager.dao.CheckpointRepository;
import ma.rfidmaroc.patrolmanager.dao.TagRepository;
import ma.rfidmaroc.patrolmanager.entities.Administrateur;
import ma.rfidmaroc.patrolmanager.entities.Checkpoint;
import ma.rfidmaroc.patrolmanager.entities.Responsable;
import ma.rfidmaroc.patrolmanager.entities.Role;
import ma.rfidmaroc.patrolmanager.entities.Tag;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;
import ma.rfidmaroc.patrolmanager.models.CheckpointForm;
import ma.rfidmaroc.patrolmanager.models.TagForm;
import ma.rfidmaroc.patrolmanager.models.UserForm;

@Service
@Transactional
public class TagServices implements ItagServices{
	
	@Autowired
	TagRepository tagRepository;


	@Override
	public Tag enregistrerTag(Tag t) {
		return tagRepository.save(t);
	}
	
	public Tag saveTagFromTagForm(TagForm tagForm) {
		Tag tag = null;
					
		tag = new Tag(tagForm.getContenu());
			
		tagRepository.save(tag);
		
		return tag;
	}
	
	public List<Tag> chercherTags(String mc)
	{
		List<Tag> list = new ArrayList<Tag>();
		list = tagRepository.chercherTags("%"+mc+"%");
		return list;
	}


}
