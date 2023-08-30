package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	@Column(length = 100) // Definindo o tamanho máximo para o campo rua
	private String rua;

	@Column(length = 10) // Definindo o tamanho máximo para o campo numero
	private String numero;

	@Column(length = 50) // Definindo o tamanho máximo para o campo bairro
	private String bairro;

	@Column(length = 50) // Definindo o tamanho máximo para o campo cidade
	private String cidade;

	@Column(length = 20) // Definindo o tamanho máximo para o campo estado
	private String estado;

	@Column(nullable = false)
	private String complemento;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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
