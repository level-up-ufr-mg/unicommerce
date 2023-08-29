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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 120)
	private String nome;
	private boolean status;

	public Categoria() {

	}

	public Categoria(String nome, boolean status) {
		this.nome = nome;
		this.status = status;
	}

	public Long getLong() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public boolean isStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", status=" + status + "]";
	}

}
