package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Universidad;

import service.UniversidadServiceAPI;

@Controller
public class UniversidadController {

	@Autowired
	private UniversidadServiceAPI universidadServiceAPI;
	
	@RequestMapping("/Universidad")
	public String indexUniversidad(Model model) {
		model.addAttribute("List", universidadServiceAPI.getAll());
		return "indexUniversidad";
	}
	
	@GetMapping("/Universidad/save/{id}")
	public String showSave(@PathVariable("id")int id,Model model) {
		if(id!=0) {
			model.addAttribute("Universidad",universidadServiceAPI.get(id));
		} else {
			model.addAttribute("Universidad",new Universidad());
		}
		return "saveUniversidad";
	}
	
	@PostMapping("/Universidad/save") 
	public String save(Universidad universidad, Model model) {
		universidadServiceAPI.save(universidad);
		return "redirect:/Universidad";
	}
	
	@GetMapping("/Universidad/delete/{id}") 
	public String delete(@PathVariable int id, Model model) {
		try {
			universidadServiceAPI.deleteID(id);
			return "redirect:/Universidad";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}