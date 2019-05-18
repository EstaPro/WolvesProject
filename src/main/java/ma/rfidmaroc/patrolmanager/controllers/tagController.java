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

import ma.rfidmaroc.patrolmanager.dao.TagRepository;
import ma.rfidmaroc.patrolmanager.entities.Tag;
import ma.rfidmaroc.patrolmanager.models.TagForm;
import ma.rfidmaroc.patrolmanager.services.TagServices;

@Controller
@RequestMapping(value = "/admin")
public class tagController {
	
	@Autowired
	TagRepository tagRepository;
	@Autowired
	TagServices tagService; 
	
	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public String tagsController(Model model, @RequestParam(name = "contenu", defaultValue = "") String mc) {
		
		model.addAttribute("tag", new TagForm());
		
		List<Tag> listTags = tagService.chercherTags(mc);
		
		
		model.addAttribute("listTags", listTags);
		model.addAttribute("motCle", mc);
		
		return "tagPage";
	}
	
	@RequestMapping(value = "/SaveTag", method = RequestMethod.POST)
	public String save(@Valid TagForm tagForm, BindingResult bindingResult) throws ParseException {
		
		if(bindingResult.hasErrors())
			return "ajouterTagForm";

		Tag tag = tagService.saveTagFromTagForm(tagForm);

		return "redirect:tag";
	}
	
	@RequestMapping(value = "/editTag")
	public String editTag(Long id, Model model) {
		
		Tag tg = tagRepository.getOne(id);
		model.addAttribute("tag", tg);

		return "EditTag";
	}
	
	@RequestMapping(value = "/UpdateTag", method = RequestMethod.POST)
	public String update(@Valid Tag tg, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "EditTag";
		}

		tagRepository.save(tg);
		
		return "redirect:tag";
	}
	
	@RequestMapping(value = "/supprimerTag")
	public String supprimerTag(Long id) {
		
		
		tagRepository.delete(id);


		return "redirect:tag";
	}

}
