package br.unitins.motoshow.model;

import javax.validation.constraints.NotEmpty;

public class Produto {

	private Integer id;
	@NotEmpty(message = "O campo nome nao pode ser vazio")
	private String descricao;
	private Double valor;
	private Integer quantidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
