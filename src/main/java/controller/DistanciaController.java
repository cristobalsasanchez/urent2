package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Distancia;

import service.DistanciaServiceAPI;

@Controller
public class DistanciaController {

	@Autowired
	private DistanciaServiceAPI distanciaServiceAPI;
	
	@RequestMapping("/Distancia")
	public String indexDistancia(Model model) {
		model.addAttribute("List", distanciaServiceAPI.getAll());
		return "indexDistancia";
	}
	
	@GetMapping("/Distancia/save/{id}")
	public String showSave(@PathVariable("id")int id,Model model) {
		if(id!=0) {
			model.addAttribute("Distancia",distanciaServiceAPI.get(id));
		} else {
			model.addAttribute("Distancia",new Distancia());
		}
		return "saveDistancia";
	}
	
	@PostMapping("/Distancia/save") 
	public String save(Distancia distancia, Model model) {
		distanciaServiceAPI.save(distancia);
		return "redirect:/Distancia";
	}
	
	@GetMapping("/Distancia/delete/{id}") 
	public String delete(@PathVariable int id, Model model) {
		try {
			distanciaServiceAPI.deleteID(id);
			return "redirect:/Distancia";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}