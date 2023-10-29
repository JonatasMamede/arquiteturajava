package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.BebidaService;

@Order(4)
@Component
public class BebidaLoader implements ApplicationRunner {

	@Autowired
	private BebidaService BebidaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		FileReader file = new FileReader("file/bebida.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			Bebida bebida = new Bebida();

			bebida.setPesoLiquido(Integer.valueOf(campos[0]));
			bebida.setAlcoolica(Boolean.valueOf(campos[1]));
			bebida.setEmbalagem(campos[2]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[3]));
			
			bebida.setVendedor(vendedor);
			
			BebidaService.incluir(bebida);
									
			linha = leitura.readLine();
		}

		for(Bebida bebida: BebidaService.obterLista()) {
			System.out.println("[Bebida] " + bebida);			
		}
		
		leitura.close();		
	}	
}