package br.com.alura.unicommerce.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 50) // Definindo o tamanho máximo para o campo nome
	private String nome;

	private boolean Status; // Booleanos não posuem lenght

	// Construtores

	public Categoria() {
	}

	public Categoria(String nome, boolean status) {
		this.nome = nome;
		Status = status;
	}

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}
}
