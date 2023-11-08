package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvendas.model.service.LimpezaService;

@Controller
public class LimpezaController {

	@Autowired
	private AppController appController;

	@Autowired
	private LimpezaService limpezaService;
	
	@GetMapping(value = "/limpeza/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		limpezaService.excluir(id);
		
		return "redirect:/limpeza/lista";
	}	

	@GetMapping(value = "/limpeza/lista")
	public String obterListaLimpeza(Model model) {

		model.addAttribute("rota", "limpeza");
		model.addAttribute("titulo", "Limpeza:");	
		model.addAttribute("listagem", limpezaService.obterLista());				
		
		return appController.showHome(model);
	}
}
