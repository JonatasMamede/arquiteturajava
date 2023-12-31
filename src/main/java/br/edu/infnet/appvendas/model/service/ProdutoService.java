package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository; 

	public Produto pesquisar(String descricao) {
		return produtoRepository.findByDescricao(descricao);
	}
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Collection<Produto> obterLista(){	
		return (Collection<Produto>) produtoRepository.findAll();
	}

	public Collection<Produto> obterLista(Integer vendedorId){	
		return (Collection<Produto>) produtoRepository.obterLista(vendedorId);
	}
	
	public long obterQtd() {
		return produtoRepository.count();
	}
}
