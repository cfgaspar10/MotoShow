package br.unitins.motoshow.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unitins.motoshow.application.Util;
import br.unitins.motoshow.model.Moto;
import br.unitins.motoshow.model.Categoria;
import br.unitins.motoshow.model.Marca;
import br.unitins.motoshow.model.Modelo;
import br.unitins.motoshow.model.Cilindrada;

public class MotoDAO extends DAO<Moto> {

	@Override
	public boolean create(Moto obj) {
		boolean resultado = false;

		// verificando se tem uma conexao valida
		if (getConnection() == null) {
			Util.addMessageError("Falha ao conectar ao Banco de Dados.");
			return false;
		}

		PreparedStatement stat = null;
		try {
			stat = getConnection().prepareStatement("INSERT INTO moto ( " + "  cilindrada, " + "  categoria, "
					+ "  modelo, " + "  cpf, " + "  nome, " + "  email, " + "  marca ) " + "VALUES ( " + " ?, " + " ?, "
					+ " ?, " + " ?, " + " ?, " + " ?, " + " ? ) ");
			stat.setInt(1, obj.getCilindrada().getValue());
			stat.setInt(2, obj.getCategoria().getValue());
			stat.setInt(3, obj.getModelo().getValue());
			stat.setString(4, obj.getCpf());
			stat.setString(5, obj.getNome());
			stat.setString(6, obj.getEmail());
			stat.setInt(7, obj.getMarca().getValue());

			stat.execute();
			Util.addMessageError("Cadastro realizado com sucesso!");
			resultado = true;
		} catch (SQLException e) {
			Util.addMessageError("Falha ao incluir.");
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public boolean update(Moto obj) {
		boolean resultado = false;

		// verificando se tem uma conexao valida
		if (getConnection() == null) {
			Util.addMessageError("Falha ao conectar ao Banco de Dados.");
			return false;
		}

		PreparedStatement stat = null;
		try {
			stat = getConnection()
					.prepareStatement("UPDATE moto SET " + "  cilindrada = ?, " + "  categoria = ?, " + "  modelo = ?, "
							+ "  cpf = ?, " + "  nome = ?, " + "  email = ?, " + "  marca = ?  " + "WHERE id = ? ");
			stat.setInt(1, obj.getCilindrada().getValue());
			stat.setInt(2, obj.getCategoria().getValue());
			stat.setInt(3, obj.getModelo().getValue());
			stat.setString(4, obj.getCpf());
			stat.setString(5, obj.getNome());
			stat.setString(6, obj.getEmail());
			stat.setInt(7, obj.getMarca().getValue());
			stat.setInt(8, obj.getId());

			stat.execute();
			Util.addMessageError("Alteracao realizada com sucesso!");
			resultado = true;
		} catch (SQLException e) {
			Util.addMessageError("Falha ao Alterar.");
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;

	}

	@Override
	public boolean delete(int id) {
		boolean resultado = false;

		// verificando se tem uma conexao valida
		if (getConnection() == null) {
			Util.addMessageError("Falha ao conectar ao Banco de Dados.");
			return false;
		}

		PreparedStatement stat = null;
		try {
			stat = getConnection().prepareStatement("DELETE FROM moto WHERE id = ? ");
			stat.setInt(1, id);

			stat.execute();
			Util.addMessageError("Exclusao realizada com sucesso!");
			resultado = true;
		} catch (SQLException e) {
			Util.addMessageError("Falha ao Excluir.");
			e.printStackTrace();
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public Moto findById(int id) {
		// verificando se tem uma conexao valida
		if (getConnection() == null) {
			Util.addMessageError("Falha ao conectar ao Banco de Dados.");
			return null;
		}
		Moto moto = null;

		PreparedStatement stat = null;

		try {
			stat = getConnection().prepareStatement("SELECT * FROM Moto WHERE id = ?");
			stat.setInt(1, id);

			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				moto = new Moto();
				moto.setId(rs.getInt("id"));
				moto.setCilindrada(Cilindrada.valueOf("cilindrada"));
				moto.setModelo(Modelo.valueOf(rs.getInt("modelo")));
				moto.setCategoria(Categoria.valueOf(rs.getInt("categoria")));
				moto.setMarca(Marca.valueOf(rs.getInt("marca")));
				moto.setCpf(rs.getString("cpf"));
				moto.setNome(rs.getString("nome"));
				moto.setEmail(rs.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			Util.addMessageError("Falha ao consultar o Banco de Dados.");
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return moto;
	}

	@Override
	public List<Moto> findAll() {
		// verificando se tem uma conexao valida
		if (getConnection() == null) {
			Util.addMessageError("Falha ao conectar ao Banco de Dados.");
			return null;
		}

		List<Moto> listaMoto = new ArrayList<Moto>();

		PreparedStatement stat = null;

		try {
			stat = getConnection().prepareStatement("SELECT * FROM Moto");
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Moto c = new Moto();
				c.setId(rs.getInt("id"));
				c.setCilindrada(Cilindrada.valueOf("cilindrada"));
				c.setModelo(Modelo.valueOf(rs.getInt("modelo")));
				c.setCategoria(Categoria.valueOf(rs.getInt("categoria")));
				c.setMarca(Marca.valueOf(rs.getInt("marca")));
				c.setCpf(rs.getString("cpf"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));

				listaMoto.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Util.addMessageError("Falha ao consultar o Banco de Dados.");
			listaMoto = null;
		} finally {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaMoto;
	}

}
