package ma.rfidmaroc.patrolmanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ma.rfidmaroc.patrolmanager.dao.UtilisateurRepository;
import ma.rfidmaroc.patrolmanager.entities.Responsable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

@Controller
public class usersController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userController(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "motCle", defaultValue = "") String mc) {
		model.addAttribute("utilisateur", new Responsable());

		Page<Utilisateur> pageUtilisateurs = utilisateurRepository.chercherUtilisateurs("%" + mc + "%",
				new PageRequest(p, 5));

		int pagesCount = pageUtilisateurs.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		model.addAttribute("pageUtilisateurs", pageUtilisateurs);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle", mc);

		return "users";
	}

	@RequestMapping(value = "/SaveUtilisateur", method = RequestMethod.POST)
	public String save(@Valid Utilisateur user, BindingResult bindingResult, Model model,
			@RequestParam(name = "page", defaultValue = "0") int p) {

		utilisateurRepository.save(user);
		Page<Utilisateur> pageUtilisateurs = utilisateurRepository.findAll(new PageRequest(p, 5));

		int pagesCount = pageUtilisateurs.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		model.addAttribute("pageUtilisateurs", pageUtilisateurs);
		model.addAttribute("pageCourante", p);

		if (bindingResult.hasErrors()) {
			return "users";
		}

		return "redirect:users";
	}

	@RequestMapping(value = "/supprimer")
	public String supprimer(Long id, Model model, @RequestParam(name = "page", defaultValue = "0") int p) {
		utilisateurRepository.delete(id);

		Page<Utilisateur> pageUtilisateurs = utilisateurRepository.findAll(new PageRequest(p, 5));

		int pagesCount = pageUtilisateurs.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		model.addAttribute("pageUtilisateurs", pageUtilisateurs);
		model.addAttribute("pageCourante", p);

		return "redirect:users";
	}

	@RequestMapping(value = "/edit")
	public String edit(Long id, Model model, @RequestParam(name = "page", defaultValue = "0") int p) {
		Utilisateur us = utilisateurRepository.getOne(id);
		model.addAttribute("utilisateur", us);

		Page<Utilisateur> pageUtilisateurs = utilisateurRepository.findAll(new PageRequest(p, 5));

		int pagesCount = pageUtilisateurs.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		model.addAttribute("pageUtilisateurs", pageUtilisateurs);
		model.addAttribute("pageCourante", p);

		return "EditUtilisateur";
	}

	@RequestMapping(value = "/UpdateUtilisateur", method = RequestMethod.POST)
	public String update(@Valid Utilisateur user, BindingResult bindingResult, Model model,
			@RequestParam(name = "page", defaultValue = "0") int p) {

		utilisateurRepository.save(user);
		Page<Utilisateur> pageUtilisateurs = utilisateurRepository.findAll(new PageRequest(p, 5));

		int pagesCount = pageUtilisateurs.getTotalPages();
		int[] pages = new int[pagesCount];
		for (int i = 0; i < pagesCount; i++) {
			pages[i] = i;
		}

		model.addAttribute("pages", pages);
		model.addAttribute("pageUtilisateurs", pageUtilisateurs);
		model.addAttribute("pageCourante", p);

		if (bindingResult.hasErrors()) {
			return "users";
		}

		return "redirect:users";
	}

}
