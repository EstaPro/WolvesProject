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
import ma.rfidmaroc.patrolmanager.dao.PatrouilleRepository;
import ma.rfidmaroc.patrolmanager.entities.Checkpoint;
import ma.rfidmaroc.patrolmanager.entities.Patrouille;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;
import ma.rfidmaroc.patrolmanager.models.CheckpointForm;
import ma.rfidmaroc.patrolmanager.models.PatrouilleForm;
import ma.rfidmaroc.patrolmanager.services.CheckpointServices;
import ma.rfidmaroc.patrolmanager.services.PatrouilleServices;

@Controller
@RequestMapping(value = "/admin")
public class patrouilleController {
	
	@Autowired
	PatrouilleRepository patrouilleRepository;
	@Autowired
	PatrouilleServices patrouilleService; 
	
	@RequestMapping(value = "/patrouille", method = RequestMethod.GET)
	public String patrouillesController(Model model, @RequestParam(name = "nom_patr", defaultValue = "") String mc) {
		
		model.addAttribute("patrouille", new PatrouilleForm());
		
		List<Patrouille> listPatrouilles = patrouilleService.chercherPatrouilles(mc);
		
		
		model.addAttribute("listPatrouilles", listPatrouilles);
		model.addAttribute("motCle", mc);
		
		return "patrouillePage";
	}
	
	@RequestMapping(value = "/SavePatrouille", method = RequestMethod.POST)
	public String save(@Valid PatrouilleForm patrouilleForm, BindingResult bindingResult) throws ParseException {
		
		if(bindingResult.hasErrors())
			return "ajouterPatrouilleForm";

		Patrouille patrouille = patrouilleService.savePatrouilleFromPatrouilleForm(patrouilleForm);

		return "redirect:patrouille";
	}
	
	@RequestMapping(value = "/editPatrouille")
	public String editPatrouille(Long id, Model model) {
		
		Patrouille pt = patrouilleRepository.getOne(id);
		model.addAttribute("patrouille", pt);

		return "EditPatrouille";
	}
	
	@RequestMapping(value = "/UpdatePatrouille", method = RequestMethod.POST)
	public String update(@Valid Patrouille pt, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "EditPatrouille";
		}

		patrouilleRepository.save(pt);
		
		return "redirect:patrouille";
	}
	
	@RequestMapping(value = "/supprimerPatrouille")
	public String supprimerPatrouille(Long id) {
		
		
		patrouilleRepository.delete(id);


		return "redirect:patrouille";
	}

}
