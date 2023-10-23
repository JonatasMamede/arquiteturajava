package br.edu.infnet.appvendas.model.domain;

public class Produto {
	private int codigo;
	private String descricao;
	private float preco;
	private boolean estoque;
	
	@Override
	public String toString() {
		return String.format("%s - %s - %.2f - %s", codigo, descricao, preco, estoque);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isEstoque() {
		return estoque;
	}
	public void setEstoque(boolean estoque) {
		this.estoque = estoque;
	}
}
