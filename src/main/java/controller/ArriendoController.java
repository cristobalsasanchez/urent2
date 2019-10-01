package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Arriendo;

import service.ArriendoServiceAPI;

@Controller
public class ArriendoController {

	@Autowired
	private ArriendoServiceAPI arriendoServiceAPI;
	
	@RequestMapping("/Arriendo")
	public String indexArriendo(Model model) {
		model.addAttribute("List", arriendoServiceAPI.getAll());
		return "indexArriendo";
	}
	
	@GetMapping("/Arriendo/save/{id}")
	public String showSave(@PathVariable("id")int id,Model model) {
		if(id!=0) {
			model.addAttribute("Arriendo",arriendoServiceAPI.get(id));
		} else {
			model.addAttribute("Arriendo",new Arriendo());
		}
		return "saveArriendo";
	}
	
	@PostMapping("/Arriendo/save") 
	public String save(Arriendo arriendo, Model model) {
		arriendoServiceAPI.save(arriendo);
		return "redirect:/Arriendo";
	}
	
	@GetMapping("/Arriendo/delete/{id}") 
	public String delete(@PathVariable int id, Model model) {
		try {
			arriendoServiceAPI.deleteID(id);
			return "redirect:/Arriendo";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}