package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "TLimpeza")
public class Limpeza extends Produto{
	
	@PositiveOrZero
	private int tamanho;
	private String fragancia;
	private String tipo;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), tamanho, fragancia, tipo);
	}	
	
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getFragancia() {
		return fragancia;
	}
	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}