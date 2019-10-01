package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Inmueble;

import service.InmuebleServiceAPI;

@Controller
public class InmuebleController {

	@Autowired
	private InmuebleServiceAPI inmuebleServiceAPI;
	
	@RequestMapping("/Inmueble")
	public String indexInmueble(Model model) {
		model.addAttribute("List", inmuebleServiceAPI.getAll());
		return "indexInmueble";
	}
	
	@GetMapping("/Inmueble/save/{id}")
	public String showSave(@PathVariable("id")int id,Model model) {
		if(id!=0) {
			model.addAttribute("Inmueble",inmuebleServiceAPI.get(id));
		} else {
			model.addAttribute("Inmueble",new Inmueble());
		}
		return "saveInmueble";
	}
	
	@PostMapping("/Inmueble/save") 
	public String save(Inmueble inmueble, Model model) {
		inmuebleServiceAPI.save(inmueble);
		return "redirect:/Inmueble";
	}
	
	@GetMapping("/Inmueble/delete/{id}") 
	public String delete(@PathVariable int id, Model model) {
		try {
			inmuebleServiceAPI.deleteID(id);
			return "redirect:/Inmueble";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}