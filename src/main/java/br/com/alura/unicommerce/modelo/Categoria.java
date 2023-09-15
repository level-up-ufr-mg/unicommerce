package br.com.alura.unicommerce.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produto = new ArrayList<>();	
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
	
	//	Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
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

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", Status=" + Status + "]";
	}

	
}
