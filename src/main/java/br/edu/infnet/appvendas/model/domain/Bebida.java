package br.edu.infnet.appvendas.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TBebida")
public class Bebida extends Produto{

	private int pesoLiquido;
	private boolean alcoolica;
	private String embalagem;

	@Override
	public String toString() {
		return String.format("%s - %s - %s - %s", super.toString(), pesoLiquido, alcoolica, embalagem);
	}
	
	public int getPesoLiquido() {
		return pesoLiquido;
	}
	public void setPesoLiquido(int pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}
	public boolean isAlcoolica() {
		return alcoolica;
	}
	public void setAlcoolica(boolean alcoolica) {
		this.alcoolica = alcoolica;
	}
	public String getEmbalagem() {
		return embalagem;
	}
	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}
}
