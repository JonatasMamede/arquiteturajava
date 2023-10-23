package br.edu.infnet.appvendas.model.domain;


public class Limpeza extends Produto{
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