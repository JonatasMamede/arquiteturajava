package br.edu.infnet.appvendas.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Limpeza;
import br.edu.infnet.appvendas.model.repository.LimpezaRepository;

@Service
public class LimpezaService {

	@Autowired
	LimpezaRepository limpezaRepository;
	
	public void incluir(Limpeza limpeza) {
		limpezaRepository.save(limpeza);
	}	

	public void excluir(Integer id) {
		limpezaRepository.deleteById(id);
	}
	
	public Collection<Limpeza> obterLista(){	
		return (Collection<Limpeza>) limpezaRepository.findAll();
	}
	
	public long obterQtd() {
		return limpezaRepository.count();
	}
}
