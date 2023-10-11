package br.com.alura.unicommerce.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.alura.unicommerce.Categoria.DadosCadastroCategoria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Categoria")
@Table(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;
	private boolean status;
	
//				*******************
//				** 	Constructor  **
//				*******************
	
	public Categoria(long id, String nome, boolean status) {
		this.nome = nome;
		this.status = status;
	}

	
	
	
	
	
	
	
	
	
	
	
//	SEMANA 04 PRA TRÁS
//	public Categoria(DadosCadastroCategoria dados) {
//		
//		this.setNome(nome);;
//		this.setStatus(true);;
//	}
//
//	public Categoria() {
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		if (nome == null || nome.isBlank()) throw new IllegalArgumentException("O Nome da categoria não pode ser NULO ou VAZIO.");
//		this.nome = nome;
//		
//	}
//
//	public boolean isStatus() {
//		return status;
//	}
//
//	public void setStatus(boolean status) {
//		this.status = status;
//	}

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
