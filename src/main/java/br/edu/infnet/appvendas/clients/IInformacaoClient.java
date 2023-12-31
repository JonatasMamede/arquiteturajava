package br.edu.infnet.appvendas.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appvendas.model.domain.Informacao;

@FeignClient(url = "http://localhost:8081/api/informacao", name = "vendasClient")
public interface IInformacaoClient {

	@GetMapping(value = "/lista")
	public List<Informacao> obterLista();
	
	@PostMapping(value = "/incluir")
	public Informacao incluir(Informacao informacao);
}
