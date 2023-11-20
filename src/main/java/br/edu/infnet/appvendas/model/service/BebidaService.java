package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.repository.BebidaRepository;

@Service
public class BebidaService {
	
	@Autowired
	private BebidaRepository bebidaRepository;

	public Collection<Bebida> pesquisar(String embalagem) {
		return bebidaRepository.findByEmbalagem(embalagem);
	}
	
	public void incluir(Bebida bebida) {
		bebidaRepository.save(bebida);
	}		

	public void excluir(Integer id) {
		bebidaRepository.deleteById(id);
	}
	
	public Collection<Bebida> obterLista(){	
		return (Collection<Bebida>) bebidaRepository.findAll();
	}
	
	public long obterQtd() {
		return bebidaRepository.count();
	}
}
