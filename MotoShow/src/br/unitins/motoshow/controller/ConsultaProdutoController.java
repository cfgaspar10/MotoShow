package br.unitins.motoshow.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.motoshow.application.Util;
import br.unitins.motoshow.dao.ProdutoDAO;
import br.unitins.motoshow.model.Produto;

@Named
@ViewScoped
public class ConsultaProdutoController  implements Serializable {


	private static final long serialVersionUID = 2165341696504601843L;


	private Produto produto;
	private String descricao;
	
	
	private List<Produto> listaProduto = null;
	
	public List<Produto> getListaProduto(){
		if (listaProduto == null) {
			ProdutoDAO dao = new ProdutoDAO();
			listaProduto = dao.findByDescricao(descricao);
			if (listaProduto == null)
				listaProduto = new ArrayList<Produto>();
			dao.closeConnection();
		}
		
		return listaProduto;
	}
	
	public void pesquisar() {
		listaProduto = null;
	}
	
	public void editar(int id) {
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.findById(id);
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("produtoFlash", produto);
		Util.redirect("produto.xhtml");
	}
	public void excluir(int id) {
		ProdutoDAO dao = new ProdutoDAO();
		if (dao.delete(id)) {
			limpar();
			// para atualizar o data table
			listaProduto = null;
		}
		dao.closeConnection();
	}
	public void limpar() {
		produto = null;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
