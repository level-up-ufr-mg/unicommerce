package br.com.alura.unicommerce.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable {
	private String tipo;

	@Column(length = 50, unique = true)
	private String nome;

	public CategoriaId() {
	}

	public CategoriaId(String tipo, String nome) {
		this.tipo = tipo;
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
