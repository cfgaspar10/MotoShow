package br.unitins.motoshow.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

public class Moto {
	private Integer id;
	private Cilindrada cilindrada;
	private Categoria categoria;
	private Modelo modelo;
	private Marca marca;
	@NotBlank(message = "O nome deve ser informado.")
	private String nome;
	@CPF
	private String cpf;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Email(message = "Email invalido.")
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

		
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Cilindrada getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Cilindrada cilindrada) {
		this.cilindrada = cilindrada;
	}

}
