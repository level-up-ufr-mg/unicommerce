package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.alura.unicommerce.record.DadosCadastroProduto;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
   
    private String descricao;
    
    @Column(name = "quantidade_estoque", nullable = false)
    private int quantidadeEstoque;

    @ManyToOne(cascade = CascadeType.ALL) // vários produtos pertencem a uma única categoria
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    
    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;
    
    //Construtor que recebe a Record (DTO)
    public Produto(DadosCadastroProduto dados, Categoria dadosIdCategoria) {
    	this.nome = dados.nome();
    	this.preco = dados.preco();
    	this.descricao = dados.descricao();
    	this.quantidadeEstoque = dados.quantidadeEstoque();
    	this.categoria = dadosIdCategoria;
    	
    }
    
    public Produto(String nome, String descricao, int quantidadeEstoque, Categoria categoria, BigDecimal preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
		this.preco = preco;
	}
     
    public Produto(Long id, String nome, String descricao, int quantidadeEstoque, Categoria categoria,
			BigDecimal preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
		this.preco = preco;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		
		if( preco.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("ERRO: O preço do produto não pode ser menor ou igual a zero.");
		}
	
		this.preco = preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", quantidadeEstoque="
				+ quantidadeEstoque + ", categoria=" + categoria + ", preco=" + preco + "]";
	}
    
    
}
