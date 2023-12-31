package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appvendas.model.domain.Informacao;
import br.edu.infnet.appvendas.model.service.InformacaoService;

@Controller
public class InformacaoController {
	
	@Autowired	
	private InformacaoService informacaoService; 
	
	@PostMapping(value = "/informacao/incluir")
	public String incluir(Informacao informacao) {
		
		System.out.println("INFORMÇÃO: " + informacao);
		
		Informacao result = informacaoService.incluir(informacao);
		
		System.out.println("RESULT: " + result);
		
		return "redirect:/";
	}	
}
