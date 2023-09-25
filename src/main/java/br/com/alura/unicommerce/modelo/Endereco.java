package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column(length = 100, nullable = false) // Definindo o tamanho máximo para o campo rua
	private String rua;

	@Column(length = 10, nullable = false) // Definindo o tamanho máximo para o campo numero
	private Integer numero;

	@Column(nullable = true)
	private String complemento;

	@Column(length = 50, nullable = false) // Definindo o tamanho máximo para o campo bairro
	private String bairro;

	@Column(length = 50, nullable = false) // Definindo o tamanho máximo para o campo cidade
	private String cidade;

	@Column(length = 20, nullable = false) // Definindo o tamanho máximo para o campo estado
	private String estado;
	
	//Construtor

	public Endereco() {
		super();
	}

	public Endereco(String rua, Integer numero, String complemento, String bairro, String cidade, String estado) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	//Getters e Setters
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
