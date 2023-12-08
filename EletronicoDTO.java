package org.libertas;

public class EletronicoDTO {

	private Integer ideletronico;
	private String nome;
	private String cor;
	private Integer qtd;
	private Integer preco;
	private String categoria;
	public Integer getIdeletronico() {
		return ideletronico;
	}
	public void setIdeletronico(Integer ideletronico) {
		this.ideletronico = ideletronico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	public Integer getPreco() {
		return preco;
	}
	public void setPreco(Integer preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public EletronicoDTO() {
		super();
		this.ideletronico = null;
		this.nome = null;
		this.cor = null;	
		this.qtd = null;
		this.preco = null;
		this.categoria = null;
	}
	
	
}
