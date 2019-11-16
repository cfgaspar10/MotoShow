package br.unitins.motoshow.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.motoshow.application.Session;
import br.unitins.motoshow.application.Util;
import br.unitins.motoshow.model.ItemVenda;
//import br.unitins.motoshow.model.ItemVenda;
import br.unitins.motoshow.model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable {
	
	
	private static final long serialVersionUID = -8708321645551357317L;

	Usuario usuarioLogado = null;
	
	int qtdItensCarrinho;
	
	public TemplateController() {
		usuarioLogado = (Usuario) Session.getInstance().getAttribute("usuarioLogado");
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("/MotoShow/faces/login.xhtml");
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
public int getQtdItensCarrinho() {
		qtdItensCarrinho = 0;
		List<ItemVenda> itens = (List<ItemVenda>) Session.getInstance().getAttribute("carrinho");
		if (itens != null)
			qtdItensCarrinho = itens.size();
		return qtdItensCarrinho;	
		
	}
	
	public void redirecionar(String pagina) {
		Util.redirect(pagina);
	}
	
	
}
