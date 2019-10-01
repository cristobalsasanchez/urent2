package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Arrendatario;

import service.ArrendatarioServiceAPI;

@Controller
public class ArrendatarioController {

	@Autowired
	private ArrendatarioServiceAPI arrendatarioServiceAPI;
	
	@RequestMapping("/Arrendatario")
	public String indexArrendatario(Model model) {
		model.addAttribute("List", arrendatarioServiceAPI.getAll());
		return "indexArrendatario\"";
	}
	
	@GetMapping("/Arrendatario/save/{id}")
	public String showSave(@PathVariable("id")String id,Model model) {
		if(id!=null) {
			model.addAttribute("Arrendatario",arrendatarioServiceAPI.get(id));
		} else {
			model.addAttribute("Arrendatario",new Arrendatario());
		}
		return "saveArrendatario";
	}
	
	@PostMapping("/Arrendatario/save") 
	public String save(Arrendatario arrendatario, Model model) {
		arrendatarioServiceAPI.save(arrendatario);
		return "redirect:/Arrendatario";
	}
	
	@GetMapping("/Arrendatario/delete/{id}") 
	public String delete(@PathVariable String id, Model model) {
		try {
			arrendatarioServiceAPI.deleteID(id);
			return "redirect:/Arrendatario";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}