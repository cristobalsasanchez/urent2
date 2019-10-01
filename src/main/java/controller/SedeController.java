package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Sede;

import service.SedeServiceAPI;

@Controller
public class SedeController {

	@Autowired
	private SedeServiceAPI sedeServiceAPI;
	
	@RequestMapping("/Sede")
	public String indexSede(Model model) {
		model.addAttribute("List", sedeServiceAPI.getAll());
		return "indexSede";
	}
	
	@GetMapping("/Sede/save/{id}")
	public String showSave(@PathVariable("id")int id,Model model) {
		if(id!=0) {
			model.addAttribute("Sede",sedeServiceAPI.get(id));
		} else {
			model.addAttribute("Sede",new Sede());
		}
		return "saveSede";
	}
	
	@PostMapping("/Sede/save") 
	public String save(Sede sede, Model model) {
		sedeServiceAPI.save(sede);
		return "redirect:/Sede";
	}
	
	@GetMapping("/Sede/delete/{id}") 
	public String delete(@PathVariable int id, Model model) {
		try {
			sedeServiceAPI.deleteID(id);
			return "redirect:/Sede";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}