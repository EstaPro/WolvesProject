package ma.rfidmaroc.patrolmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class homeController {
	@RequestMapping(value="/home")
	public String homeController() {
		return "index";
	}
}
