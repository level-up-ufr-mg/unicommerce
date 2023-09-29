package br.com.alura.unicommerce.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private boolean status;

//	=====================================
//	-------------------------------------

	public Categoria(String nome) {
		this.nome = nome;
		this.status = true;
	}

	public Categoria() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

//	@EmbeddedId
//	private CategoriaId id;
//	
////	@OneToMany(mappedBy = "categoria")
////	private List<Produto> produto = new ArrayList<>();	
//
//	
//	private boolean Status; // Booleanos não posuem lenght
//
//	// Construtores
//
//	public Categoria() {
//	}
//
//	public Categoria(String nome, boolean status) {
//		this.id = new CategoriaId(nome, "xpto");
//	}
//	
//	//	Getters and Setters
//	
//	public CategoriaId getId() {
//		return id;
//	}
//
//	public void setId(CategoriaId id) {
//		this.id = id;
//	}
//
////	public List<Produto> getProduto() {
////		return produto;
////	}
////
////	public void setProduto(List<Produto> produto) {
////		this.produto = produto;
////	}
//
////	public Produto getProduto() {
////		return produto;
////	}
////
////	public void setProduto(Produto produto) {
////		this.produto = produto;
////	}
//	
//	public String getNome() {
//		return this.id.getNome();
//	}
//
//	public boolean isStatus() {
//		return Status;
//	}
//
//	public void setStatus(boolean status) {
//		Status = status;
//	}
//
//	@Override
//	public String toString() {
//		return "Categoria [id=" + id +   ", Status=" + Status + "]";
//	}
}
