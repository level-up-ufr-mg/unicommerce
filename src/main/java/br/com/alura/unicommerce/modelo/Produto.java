package br.com.alura.unicommerce.modelo;

import java.math.BigDecimal;

import br.com.alura.unicommerce.Excepion.PrecoInvalidoException;
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
	private Long produtoId;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Long quantidadeEstoque;
	@Column(nullable = false)
	private BigDecimal Preco;
	
	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoriaId;
	// ==================== Variaveis de Relacionamento================

	public Produto() {
	}  
 

	

 
	
	public Produto(Long produtoId, String nome, String descricao, Long quantidadeEstoque, BigDecimal preco,
			Categoria categoriaId) {
		this.produtoId = produtoId;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		Preco = preco;
		this.categoriaId = categoriaId;
	}




	public void setPrecoUntario(BigDecimal preco) throws PrecoInvalidoException {
	    if (preco.compareTo(BigDecimal.ZERO) <= 0) {
	        throw new PrecoInvalidoException("O preço unitário deve ser maior que zero.  " + preco);
	    }
	    this.Preco = preco;
	}


	public Long getProdutoId() {
		return produtoId;
	}


	public String getNome() {
		return nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public Long getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	public BigDecimal getPreco() {
		return Preco;
	}


	public Categoria getCategoriaId() {
		return categoriaId;
	}


	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setQuantidadeEstoque(Long quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public void setPreco(BigDecimal preco) {
		Preco = preco;
	}


	public void setCategoriaId(Categoria categoriaId) {
		this.categoriaId = categoriaId;
	}


	@Override
	public String toString() {
		return "Produto [PRODUTO_ID=" + produtoId + ", NOME=" + nome + ", DESCRICAO=" + descricao
				+ ", QUANTIDADE_ESTOQUE=" + quantidadeEstoque + ", categoria=" + categoriaId + "]";
	}

	
	
}
