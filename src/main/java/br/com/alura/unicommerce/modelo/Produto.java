package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 200)
	private String nome;
	
	private String descricao;
	
	@Column(name = "preco", nullable = false)
	private BigDecimal preco;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEstoque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	public Produto() {}
	
	public Produto(String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		if (preco.compareTo( new BigDecimal("0.00")) <= 0) {
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a 0.");
        }
		
		this.preco = preco;
	}
}
