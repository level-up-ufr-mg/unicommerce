package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 100) // Definindo o tamanho máximo para o campo nome
	private String nome;

	@Column(precision = 10, scale = 2) // Definindo precisão e escala para o campo preco (exemplo: até 10 dígitos
										// totais e 2 casas decimais)
	private BigDecimal preco;

	@Column(nullable = false, length = 200) // Definindo o tamanho máximo para o campo descricao e tornando-o
											// obrigatório
	private String descricao;

	@Column // O tamanho máximo será determinado automaticamente com base no tipo Integer
	private Integer quantidade_estoque;

	@ManyToOne
	@JoinColumn(name = "id")
	private Categoria categoria;
	
	
	
	

	public Produto() { // construtor default
	}

	public Produto(String nome, BigDecimal preco, String descricao, Integer quantidade_estoque, Categoria categoria) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade_estoque = quantidade_estoque;
		this.categoria = categoria;
	}

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
