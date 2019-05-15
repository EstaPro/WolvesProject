package ma.rfidmaroc.patrolmanager.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ma.rfidmaroc.patrolmanager.dao.CheckpointRepository;
import ma.rfidmaroc.patrolmanager.entities.Checkpoint;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;
import ma.rfidmaroc.patrolmanager.models.CheckpointForm;
import ma.rfidmaroc.patrolmanager.services.CheckpointServices;

@Controller
@RequestMapping(value = "/admin")
public class checkpointController {
	
	@Autowired
	CheckpointRepository checkpointRepository;
	@Autowired
	CheckpointServices checkpointService; 
	
	@RequestMapping(value = "/checkpoint", method = RequestMethod.GET)
	public String checkpointsController(Model model, @RequestParam(name = "geo_location", defaultValue = "") String mc) {
		
		model.addAttribute("checkpoint", new CheckpointForm());
		
		List<Checkpoint> listCheckpoints = checkpointService.chercherCheckpoints(mc);
		
		
		model.addAttribute("listCheckpoints", listCheckpoints);
		model.addAttribute("motCle", mc);
		
		return "checkpointPage";
	}
	
	@RequestMapping(value = "/SaveCheckpoint", method = RequestMethod.POST)
	public String save(@Valid CheckpointForm checkpointForm, BindingResult bindingResult) throws ParseException {
		
		if(bindingResult.hasErrors())
			return "ajouterCheckpointForm";

		Checkpoint checkpoint = checkpointService.saveCheckpointFromCheckpointForm(checkpointForm);

		return "redirect:checkpoint";
	}
	
	@RequestMapping(value = "/editCheckpoint")
	public String editCheckpoint(Long id, Model model) {
		
		Checkpoint ck = checkpointRepository.getOne(id);
		model.addAttribute("checkpoint", ck);

		return "EditCheckpoint";
	}
	
	@RequestMapping(value = "/UpdateCheckpoint", method = RequestMethod.POST)
	public String update(@Valid Checkpoint ck, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "EditCheckpoint";
		}

		checkpointRepository.save(ck);
		
		return "redirect:checkpoint";
	}
	
	@RequestMapping(value = "/supprimerCheckpoint")
	public String supprimerCheckpoint(Long id) {
		
		
		checkpointRepository.delete(id);


		return "redirect:checkpoint";
	}

}
