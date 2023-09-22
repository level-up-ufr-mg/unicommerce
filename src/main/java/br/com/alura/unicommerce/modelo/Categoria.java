package br.com.alura.unicommerce.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@EmbeddedId
	private CategoriaId id;
	
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produto = new ArrayList<>();	
	
	private boolean Status; // Booleanos não posuem lenght

	// Construtores

	public Categoria() {
	}

	public Categoria(String nome, boolean status) {
		this.id = new CategoriaId(nome, "xpto");
	}
	
	//	Getters and Setters

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public String getNome() {
		return this.id.getNome();
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", produto=" + produto + ", Status=" + Status + "]";
	}
}
