package br.edu.infnet.appvendas.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvendas.model.domain.Limpeza;

@Service
public class LimpezaService {
	
	private Map<Integer, Limpeza> mapaLimpeza = new HashMap<Integer, Limpeza>();

	public void incluir(Limpeza limpeza) {
		mapaLimpeza.put(limpeza.getCodigo(), limpeza);
	}
	
	public Collection<Limpeza> obterLista(){	
		return mapaLimpeza.values();
	}
}
