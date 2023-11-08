package br.edu.infnet.appvendas;

import java.io.BufferedReader;
import java.io.FileReader;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvendas.model.domain.Limpeza;
import br.edu.infnet.appvendas.model.domain.Bebida;
import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("file/produto.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		Vendedor vendedor = new Vendedor();
		
		while(linha != null) {
			
			campos = linha.split(";");

			
			switch (campos[7]) {
			case "L":
				Limpeza limpeza = new Limpeza();
				limpeza.setCodigo(Integer.valueOf(campos[0]));
				limpeza.setDescricao(campos[1]);
				limpeza.setEstoque(Boolean.valueOf(campos[2]));
				limpeza.setPreco(Float.valueOf(campos[3]));
				limpeza.setTamanho(Integer.valueOf(campos[4]));
				limpeza.setFragancia(campos[5]);
				limpeza.setTipo(campos[6]);

				vendedor.setId(Integer.valueOf(campos[8]));			
				
				limpeza.setVendedor(vendedor);
				
				try {
					produtoService.incluir(limpeza);				
				}catch(ConstraintViolationException e){
					FileLogger.logException("[PRODUTO - LIMPEZA]" + limpeza + " - "+ e.getMessage());
				}
				
				break;

			case "B":
				Bebida bebida = new Bebida();
				bebida.setCodigo(Integer.valueOf(campos[0]));
				bebida.setDescricao(campos[1]);
				bebida.setEstoque(Boolean.valueOf(campos[2]));
				bebida.setPreco(Float.valueOf(campos[3]));
				bebida.setPesoLiquido(Integer.valueOf(campos[4]));
				bebida.setAlcoolica(Boolean.valueOf(campos[5]));
				bebida.setEmbalagem(campos[6]);

				vendedor.setId(Integer.valueOf(campos[8]));
				
				bebida.setVendedor(vendedor);
				
				try {
					produtoService.incluir(bebida);				
				}catch(ConstraintViolationException e){
					FileLogger.logException("[PRODUTO - BEBIDA]" + bebida + " - "+ e.getMessage());
				}
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		
		leitura.close();
		
	}	
}
