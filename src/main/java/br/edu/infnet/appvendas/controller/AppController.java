package br.edu.infnet.appvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvendas.model.service.BebidaService;
import br.edu.infnet.appvendas.model.service.LimpezaService;
import br.edu.infnet.appvendas.model.service.ProdutoService;
import br.edu.infnet.appvendas.model.service.VendedorService;

@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private BebidaService bebidaService;
	@Autowired
	private LimpezaService limpezaService;
	
	@GetMapping(value = "/")
	public String showHome(Model model) {

		model.addAttribute("qtdVendedor", vendedorService.obterQtde());	
		model.addAttribute("qtdProduto", produtoService.obterQtd());	
		model.addAttribute("qtdBebida", bebidaService.obterQtd());	
		model.addAttribute("qtdLimpeza", limpezaService.obterQtd());	
		
		return "home";
	}
}
