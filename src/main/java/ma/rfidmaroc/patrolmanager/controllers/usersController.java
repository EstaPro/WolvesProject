package ma.rfidmaroc.patrolmanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.rfidmaroc.patrolmanager.dao.UtilisateurRepository;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

@Controller
public class usersController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String usersController(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "users";
	}
	
	@RequestMapping(value="/SaveUtilisateur", method=RequestMethod.POST)
	public String save(@Valid Utilisateur user, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "users";
		}
		utilisateurRepository.save(user);
		return "users";
	}
	
	
}
