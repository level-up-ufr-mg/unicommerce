package br.com.alura.unicommerce.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "unicommerce", name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long PRODUTO_ID;
	private String NOME;
	private String DESCRICAO;
	private Long QUANTIDADE_ESTOQUE;
	
	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "CATEGORIA_ID")
	private Categoria categoria;
	// ==================== Variaveis de Relacionamento================

	public Produto() {
	}

	public Produto(Long iD, String nOME, String dESCRICAO, Long qUANTIDADE_ESTOQUE, Categoria cATEGORIA_ID) {
		PRODUTO_ID = iD;
		NOME = nOME;
		DESCRICAO = dESCRICAO;
		QUANTIDADE_ESTOQUE = qUANTIDADE_ESTOQUE;
		categoria = cATEGORIA_ID;
	}

	public Long getID() {
		return PRODUTO_ID;
	}

	public String getNOME() { 
		return NOME;
	}

	public String getDESCRICAO() {
		return DESCRICAO;
	}

	public Long getQUANTIDADE_ESTOQUE() {
		return QUANTIDADE_ESTOQUE;
	}

	
	public Categoria getCATEGORIA_ID() {
		return categoria;
	}

	public void setID(Long iD) {
		PRODUTO_ID = iD;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}

	public void setQUANTIDADE_ESTOQUE(Long qUANTIDADE_ESTOQUE) {
		QUANTIDADE_ESTOQUE = qUANTIDADE_ESTOQUE;
	}

	public void setCATEGORIA_ID(Categoria cATEGORIA_ID) {
		categoria = cATEGORIA_ID;
	}

}
