package br.unitins.motoshow.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.motoshow.application.Util;
import br.unitins.motoshow.dao.MotoDAO;
import br.unitins.motoshow.model.Moto;

@Named
@ViewScoped
public class ConsultaMotoController implements Serializable {

	
	private static final long serialVersionUID = -2937253840273075645L;
	
	private Moto moto;
	private String nome;

	int id;

	private List<Moto> listaMoto = null;

	public List<Moto> getListaMoto() {
		if (listaMoto == null) {
			MotoDAO dao = new MotoDAO();
			listaMoto = (List<Moto>) dao.findById(id);
			if (listaMoto == null)
				listaMoto = new ArrayList<Moto>();
			dao.closeConnection();
		}

		return listaMoto;
	}

	public void pesquisar() {
		listaMoto = null;
	}

	public void editar(int id) {
		MotoDAO dao = new MotoDAO();
		Moto moto = dao.findById(id);
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("bikeFlash", moto);
		Util.redirect("bike.xhtml");
	}

	public void excluir(int id) {
		MotoDAO dao = new MotoDAO();
		if (dao.delete(id)) {
			limpar();
			// para atualizar o data table
			listaMoto = null;
		}
		dao.closeConnection();
	}

	public void limpar() {
		moto = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setListaMoto(List<Moto> listaMoto) {
		this.listaMoto = listaMoto;
	}

	public Moto getMoto() {
		if (moto == null) {
			moto = new Moto();
		}

		return moto;
	}

	public void setBike(Moto moto) {
		this.moto = moto;
	}

}
