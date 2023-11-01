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

		model.addAttribute("qtdVendedor", vendedorService.obterQtd());	
		model.addAttribute("qtdProduto", produtoService.obterQtd());	
		model.addAttribute("qtdBebida", bebidaService.obterQtd());	
		model.addAttribute("qtdLimpeza", limpezaService.obterQtd());	
		
		return "home";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterListaVendedor(Model model) {

		model.addAttribute("titulo", "Vendedore:");	
		model.addAttribute("listagem", vendedorService.obterLista());				
		
		return showHome(model);
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {

		model.addAttribute("titulo", "Produtos:");	
		model.addAttribute("listagem", produtoService.obterLista());				
		
		return showHome(model);
	}
	
	@GetMapping(value = "/bebida/lista")
	public String obterListaBebida(Model model) {

		model.addAttribute("titulo", "Bebidas:");	
		model.addAttribute("listagem", bebidaService.obterLista());				
		
		return showHome(model);
	}
	
	@GetMapping(value = "/limpeza/lista")
	public String obterListaLimpeza(Model model) {

		model.addAttribute("titulo", "Limpeza:");	
		model.addAttribute("listagem", limpezaService.obterLista());				
		
		return showHome(model);
	}
}
