package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@NamedQuery(name = "Produto.produtosPorCategoria", 
query = "SELECT p FROM Produto p WHERE p.categoria.id.nome = :nome") 
@Inheritance(strategy = InheritanceType.JOINED)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	@OneToMany
	private List<ItemPedido> itens = new ArrayList<>();	
	@Column(length = 100, nullable = false) // Definindo o tamanho máximo para o campo nome
	private String nome;
	@Column(precision = 10, scale = 2, nullable = false) 
	private BigDecimal preco;
	@Column(length = 200)
	private String descricao;
	@Column(nullable = false) // O tamanho máximo será determinado automaticamente com base no tipo Integer
	private Integer quantidade_estoque;

	//Construtor
	
	public Produto() { // construtor default
	}
	
	public Produto(String nome, BigDecimal preco, String descricao, Integer quantidade_estoque, Categoria categoria) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade_estoque = quantidade_estoque;
		this.categoria = categoria;
	}

	//Getters e Setters

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}
}
