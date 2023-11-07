package br.com.alura.unicommerce.Domain.Endereco;

import br.com.alura.unicommerce.DTO.DadosEndereco;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco() {
	}

	public Endereco(DadosEndereco dados) {
		this.rua = dados.rua();
		this.numero = String.valueOf(dados.numero());
		this.complemento = dados.complemento();
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.estado = dados.estado();
	}

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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
}