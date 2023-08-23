package br.edu.uniformg.unicommerce.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    
    //FK
    private Categoria categoriaId;

    public Produto() {
    }

    public Produto(String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque,
			Categoria categoriaId) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoriaId = categoriaId;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public Categoria getCategoriaId() {
		return categoriaId;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	public Categoria getCategoria_id() {
		return categoriaId;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void setCategoriaId(Categoria categoriaId) {
		this.categoriaId = categoriaId;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public void setCategoria_id(Categoria categoria_id) {
		this.categoriaId = categoria_id;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", quantidadeEstoque=" + quantidadeEstoque + ", categoriaId=" + categoriaId + "]";
	}


}



