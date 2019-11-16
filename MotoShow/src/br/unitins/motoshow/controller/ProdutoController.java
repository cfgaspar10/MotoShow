package br.unitins.motoshow.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.motoshow.dao.ProdutoDAO;
import br.unitins.motoshow.model.Produto;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = -494732751285478566L;

	private Produto produto;
	
	public ProdutoController() {
		Flash flash = FacesContext.
				getCurrentInstance().
				getExternalContext().getFlash();
		flash.keep("produtoFlash");
		produto = (Produto) flash.get("produtoFlash");
	}
	
	private List<Produto> listaProduto = null;
	
	public List<Produto> getListaProduto(){
		if (listaProduto == null) {
			ProdutoDAO dao = new ProdutoDAO();
			listaProduto = dao.findAll();
			if (listaProduto == null)
				listaProduto = new ArrayList<Produto>();
			dao.closeConnection();
		}
		
		return listaProduto;
	}
	
	public void editar(int id) {
		ProdutoDAO dao = new ProdutoDAO();
		setProduto(dao.findById(id));
	}
	
	
	public void incluir() {
		ProdutoDAO dao = new ProdutoDAO();

		if (dao.create(getProduto())) {
			limpar();
			// para atualizar o data table
			listaProduto = null;
		}
		dao.closeConnection();
	}
	
	public void alterar() {
		ProdutoDAO dao = new ProdutoDAO();
		if (dao.update(getProduto())) {
			limpar();
			// para atualizar o data table
			listaProduto = null;
		}
		dao.closeConnection();
	}
	
	public void excluir() {
		ProdutoDAO dao = new ProdutoDAO();
		if (dao.delete(getProduto().getId())) {
			limpar();
			// para atualizar o data table
			listaProduto = null;
		}
		dao.closeConnection();
	}
	
	public void limpar() {
		produto = null;
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
