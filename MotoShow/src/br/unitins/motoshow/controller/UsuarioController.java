package br.unitins.motoshow.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.motoshow.application.Util;
import br.unitins.motoshow.dao.UsuarioDAO;
import br.unitins.motoshow.model.Perfil;
import br.unitins.motoshow.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {


	private static final long serialVersionUID = 349918934791535468L;

	private Usuario usuario;
	
	private List<Usuario> listaUsuario = null;
	
	public UsuarioController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		usuario = (Usuario) flash.get("usuarioFlash");
	}
	
	public List<Usuario> getListaUsuario(){
		if (listaUsuario == null) {
			UsuarioDAO dao = new UsuarioDAO();
			listaUsuario = dao.findAll();
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
			dao.closeConnection();
		}
		
		return listaUsuario;
	}
	
	public void editar(int id) {
		UsuarioDAO dao = new UsuarioDAO();
		setUsuario(dao.findById(id));
	}
	
	
	public void incluir() {
		// encriptando a senha do usuario
		getUsuario().setSenha(Util.encrypt(getUsuario().getSenha()));
		
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.create(getUsuario())) {
			limpar();
			// para atualizar o data table
			listaUsuario = null;
		}
		dao.closeConnection();
	}
	
	public void alterar() {
		// encriptando a senha do usuario
		getUsuario().setSenha(Util.encrypt(getUsuario().getSenha()));
		
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.update(getUsuario())) {
			limpar();
			// para atualizar o data table
			listaUsuario = null;
		}
		dao.closeConnection();
	}
	
	public void excluir() {
		UsuarioDAO dao = new UsuarioDAO();
		if (dao.delete(getUsuario().getId())) {
			limpar();
			// para atualizar o data table
			listaUsuario = null;
		}
		dao.closeConnection();
	}
	
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}
	
	public void limpar() {
		usuario = null;
	}

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}

