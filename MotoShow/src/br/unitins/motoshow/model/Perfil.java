package br.unitins.motoshow.model;

import java.util.Arrays;
import java.util.List;

public enum Perfil {
	
	ADMINISTRADOR(1, "Administrador", Arrays.asList("consultausuario","moto.xhtml","usuario.xhtml", "template.xhtml", "produto.xhtml", "vendaproduto.xhtml", "carrinho.xhtml", "historico.xhtml","consultarMoto.xhtml","consultarProduto.xhtml", "detalhesvenda.xhtml")),
	GERENTE(2, "Gerente" , Arrays.asList( "template.xhtml", "consultarMoto.xhtml","consultarProduto.xhtml","produto.xhtml", "vendaproduto.xhtml", "carrinho.xhtml", "historico.xhtml", "detalhesvenda.xhtml")),
	FUNCIONARIO(3, "Funcionario", Arrays.asList("template.xhtml","consultarMoto.xhtml","consultarProduto.xhtml","vendaproduto.xhtml", "carrinho.xhtml", "historico.xhtml", "detalhesvenda.xhtml"));

	private int value;
	private String label;
	private List<String> pages;
	
	Perfil(int value, String label, List<String> pages) {
		this.value = value;
		this.label = label;
		this.pages = pages;
		
	}

	public int getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	public List<String> getPages() {
		return pages;
	}
	
	// retorna um perfil a partir de um valor inteiro
	public static Perfil valueOf(int value) {
		for (Perfil perfil : Perfil.values()) {
			if (perfil.getValue() == value) {
				return perfil;
			}
		}
		return null;
	}
	
}