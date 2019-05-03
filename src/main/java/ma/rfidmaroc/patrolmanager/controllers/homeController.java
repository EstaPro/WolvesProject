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
public class homeController {
	
		
	@RequestMapping(value="/home")
	public String homeController() {
		return "index";
	}
	
	@RequestMapping(value="/")
	public String homePage() {
		return "redirect:home";
	}
	
	@RequestMapping(value="/login")
	public String loginController() {
		return "login";
	}
	
}
