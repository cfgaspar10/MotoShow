package br.unitins.motoshow.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.motoshow.dao.MotoDAO;
import br.unitins.motoshow.model.Moto;
import br.unitins.motoshow.model.Categoria;
import br.unitins.motoshow.model.Marca;
import br.unitins.motoshow.model.Modelo;
import br.unitins.motoshow.model.Cilindrada;

@Named
@ViewScoped
public class MotoController implements Serializable {

	private static final long serialVersionUID = 2272373226324001601L;

	private Moto moto;

	private List<Moto> listaMoto = null;

	public List<Moto> getListaMoto() {
		if (listaMoto == null) {
			MotoDAO dao = new MotoDAO();
			listaMoto = dao.findAll();
			if (listaMoto == null)
				listaMoto = new ArrayList<Moto>();
			dao.closeConnection();
		}

		return listaMoto;
	}

	public void editar(int id) {
		MotoDAO dao = new MotoDAO();
		setMoto(dao.findById(id));
	}

	public void incluir() {
		MotoDAO dao = new MotoDAO();

		if (dao.create(getMoto())) {
			limpar();
			// para atualizar o data table
			listaMoto = null;
		}
		dao.closeConnection();
	}

	public void alterar() {
		MotoDAO dao = new MotoDAO();
		if (dao.update(getMoto())) {
			limpar();
			// para atualizar o data table
			listaMoto = null;
		}
		dao.closeConnection();
	}

	public void excluir() {
		MotoDAO dao = new MotoDAO();
		if (dao.delete(getMoto().getId())) {
			limpar();
			// para atualizar o data table
			listaMoto = null;
		}
		dao.closeConnection();
	}

	public Cilindrada[] getListaCilindradas() {
		return Cilindrada.values();
	}

	public Marca[] getListaMarca() {
		return Marca.values();
	}

	public Modelo[] getListaModelo() {
		return Modelo.values();
	}

	public Categoria[] getListaCategoria() {
		return Categoria.values();
	}

	public void limpar() {
		setMoto(null);
	}

	public Moto getMoto() {
		if (moto == null) {
			moto = new Moto();
		}
		return moto;
	}

	public void setMoto(Moto moto) {
		this.moto = moto;
	}


}
