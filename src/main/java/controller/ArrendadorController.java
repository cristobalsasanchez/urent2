package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Arrendador;

import service.ArrendadorServiceAPI;

@Controller
public class ArrendadorController {

	@Autowired
	private ArrendadorServiceAPI arrendadorServiceAPI;
	
	@RequestMapping("/Arrendador")
	public String indexArrendador(Model model) {
		model.addAttribute("List", arrendadorServiceAPI.getAll());
		return "indexArrendador";
	}
	@GetMapping("/Arrendador/save/{id}")
	public String showSave(@PathVariable("id")String id,Model model) {
		if(id!=null) {
			model.addAttribute("Arrendador",arrendadorServiceAPI.get(id));
		} else {
			model.addAttribute("condicion",new Arrendador());
		}
		return "saveArrendador";
	}
	@PostMapping("/Arrendador/save") 
	public String save(Arrendador arrendador, Model model) {
		arrendadorServiceAPI.save(arrendador);
		return "redirect:/Arrendador";
	}
	@GetMapping("/Arrendador/delete/{id}") 
	public String delete(@PathVariable String id, Model model) {
		try {
			arrendadorServiceAPI.deleteID(id);
			return "redirect:/Arrendador";
			}
		catch(Exception ExceptionMapperStandardImpl) {
			return "mensajeError";
		}
	}
}
