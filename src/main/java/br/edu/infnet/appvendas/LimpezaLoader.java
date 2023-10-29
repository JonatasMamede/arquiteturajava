package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.service.LimpezaService;
import br.edu.infnet.appvendas.model.domain.Limpeza;
import br.edu.infnet.appvendas.model.domain.Vendedor;

@Order(3)
@Component
public class LimpezaLoader implements ApplicationRunner {

	@Autowired
	private LimpezaService LimpezaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		FileReader file = new FileReader("file/limpeza.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Limpeza limpeza = new Limpeza();
			
			limpeza.setTamanho(Integer.valueOf(campos[0]));
			limpeza.setFragancia(campos[1]);
			limpeza.setTipo(campos[2]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[3]));			
			
			limpeza.setVendedor(vendedor);
			
			LimpezaService.incluir(limpeza);
									
			linha = leitura.readLine();
		}

		for(Limpeza limpeza: LimpezaService.obterLista()) {
			System.out.println("[Limpeza] " + limpeza);			
		}
		
		leitura.close();		
	}	
}