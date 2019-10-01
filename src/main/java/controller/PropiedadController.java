package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Propiedad;

import service.PropiedadServiceAPI;

@Controller
public class PropiedadController {

	@Autowired
	private PropiedadServiceAPI propiedadServiceAPI;
	
	@RequestMapping("/Propiedad")
	public String indexPropiedad(Model model) {
		model.addAttribute("List", propiedadServiceAPI.getAll());
		return "indexPropiedad";
	}
	
	@GetMapping("/Propiedad/save/{id}")
	public String showSave(@PathVariable("id")int id,Model model) {
		if(id!=0) {
			model.addAttribute("Propiedad",propiedadServiceAPI.get(id));
		} else {
			model.addAttribute("Propiedad",new Propiedad());
		}
		return "savePropiedad";
	}
	
	@PostMapping("/Propiedad/save") 
	public String save(Propiedad propiedad, Model model) {
		propiedadServiceAPI.save(propiedad);
		return "redirect:/Propiedad";
	}
	
	@GetMapping("/Propiedad/delete/{id}") 
	public String delete(@PathVariable int id, Model model) {
		try {
			propiedadServiceAPI.deleteID(id);
			return "redirect:/Propiedad";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}