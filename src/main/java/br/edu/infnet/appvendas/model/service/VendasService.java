package br.edu.infnet.appvendas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.clients.IInformacaoClient;
import br.edu.infnet.appvendas.model.domain.Informacao;

@Service
public class VendasService {
	
	@Autowired
	private IInformacaoClient informacaoClient; 
	
	public List<Informacao> obterInformacao(){
		return informacaoClient.obterLista();
	};
}
