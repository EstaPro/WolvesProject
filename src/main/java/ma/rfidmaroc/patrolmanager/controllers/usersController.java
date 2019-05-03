package ma.rfidmaroc.patrolmanager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ma.rfidmaroc.patrolmanager.dao.UtilisateurRepository;
import ma.rfidmaroc.patrolmanager.entities.Utilisateur;

@Controller
public class usersController {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String usersController(Model model,
			@RequestParam(name="page",defaultValue="0")int p ,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		model.addAttribute("utilisateur", new Utilisateur());
		
		Page<Utilisateur> pageEtudiants = utilisateurRepository.chercherUtilisateurs("%"+mc+"%",new PageRequest(p, 5));
		
		int pagesCount = pageEtudiants.getTotalPages();
		int[] pages=new int[pagesCount];
		for(int i=0;i<pagesCount;i++)
		{
			pages[i]=i;
		}
		
		model.addAttribute("pages",pages);
		model.addAttribute("pageUtilisateurs",pageEtudiants);
		model.addAttribute("pageCourante", p);
		model.addAttribute("motCle",mc);
		
		return "users";
	}
	
	@RequestMapping(value="/SaveUtilisateur", method=RequestMethod.POST)
	public String save(@Valid Utilisateur user, BindingResult bindingResult,
			Model model, @RequestParam(name="page",defaultValue="0")int p) {
		
		utilisateurRepository.save(user);
	    Page<Utilisateur> pageEtudiants = utilisateurRepository.findAll(new PageRequest(p, 5));
		
		int pagesCount = pageEtudiants.getTotalPages();
		int[] pages=new int[pagesCount];
		for(int i=0;i<pagesCount;i++)
		{
			pages[i]=i;
		}
		
		model.addAttribute("pages",pages);
		model.addAttribute("pageUtilisateurs",pageEtudiants);
		model.addAttribute("pageCourante", p);
		
		if(bindingResult.hasErrors())
		{
			return "users";
		}
		
		return "users";
	}
	
}
