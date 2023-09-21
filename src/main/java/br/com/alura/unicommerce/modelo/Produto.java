package br.com.alura.unicommerce.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "produto")
@NamedQuery(name = "Produto.produtosPorCategoria", 
            query = "SELECT p FROM Produto p "
            		+ "WHERE p.categoria.nome = :nome")// quando você quiser fazer a consulta direto na entidade
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
   
    private String descricao;
    
    @Column(name = "quantidade_estoque", nullable = false)
    private int quantidadeEstoque;

    @ManyToOne(fetch = FetchType.LAZY) // vários produtos pertencem a uma única categoria
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    
    @Column(name = "preco", precision = 10, scale = 2, nullable = false)
    private BigDecimal preco;
    
    public Produto() {
    	
    }

    
	public Produto(String nome, BigDecimal preco, Categoria categoria) {
		this.setPreco(preco);	
	}    
    
    public Produto(String nome, String descricao, int quantidadeEstoque, Categoria categoria, BigDecimal preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
		this.preco = preco;
	}

    
    public Produto(DadosCadastraProduto dados, Categoria dadosIdCategoria) {
		this.nome = dados.nome();
		this.preco = dados.preco();
		this.descricao = dados.descricao();
		this.quantidadeEstoque = dados.quantidadeEstoque();
		this.categoria = dadosIdCategoria;
		
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
}
