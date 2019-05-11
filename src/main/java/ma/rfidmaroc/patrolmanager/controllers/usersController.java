package ma.rfidmaroc.patrolmanager.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.rfidmaroc.patrolmanager.dao.AdministrateurRepository;
import ma.rfidmaroc.patrolmanager.dao.PatrouilleurRepository;
import ma.rfidmaroc.patrolmanager.dao.ResponsableRepository;
import ma.rfidmaroc.patrolmanager.dao.RoleRepository;
import ma.rfidmaroc.patrolmanager.dao.UtilisateurRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import ma.rfidmaroc.patrolmanager.entities.Administrateur;
import ma.rfidmaroc.patrolmanager.entities.Responsable;
import ma.rfidmaroc.patrolmanager.entities.Role;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;
import ma.rfidmaroc.patrolmanager.models.UserForm;
import ma.rfidmaroc.patrolmanager.services.UtilisatateurServices;

@Controller
@RequestMapping(value = "/admin")
public class usersController {

	@Autowired
	AdministrateurRepository administrateurRepository;
	@Autowired
	ResponsableRepository responsableRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PatrouilleurRepository patrouilleurRepository;
	@Autowired
	UtilisateurRepository userRepository;
	@Autowired
	UtilisatateurServices userService;
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userController(Model model, @RequestParam(name = "cin", defaultValue = "") String mc,
			@RequestParam(name = "role", defaultValue = "") String role) {
		model.addAttribute("utilisateur", new UserForm());

		List<Utilisateur> listUtilisateurs = userService.chercherUtilisateurs(mc,role);
		
		
		model.addAttribute("listUtilisateurs", listUtilisateurs);
		model.addAttribute("motCle", mc);
		model.addAttribute("role", role);

		return "usersPage";
	}

	@RequestMapping(value = "/SaveUtilisateur", method = RequestMethod.POST)
	public String save(@Valid UserForm userForm, BindingResult bindingResult) throws ParseException {
		
		if(bindingResult.hasErrors())
			return "ajouterUserForm";

		Utilisateur user = userService.saveUserFromUserForm(userForm);

		return "redirect:users";
	}

	@RequestMapping(value = "/supprimer")
	public String supprimer(Long id) {
		
		
		userRepository.delete(id);


		return "redirect:users";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long id, Model model) {
		
		Utilisateur us = userRepository.getOne(id);
		model.addAttribute("utilisateur", us);

		return "EditUtilisateur";
	}

	@RequestMapping(value = "/UpdateUtilisateur", method = RequestMethod.POST)
	public String update(@Valid Utilisateur user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "EditUtilisateur";
		}

		System.out.println(user.getId_user());
		System.out.println(user);

		//userRepository.save(user);
		
		return "redirect:users";
	}
}
