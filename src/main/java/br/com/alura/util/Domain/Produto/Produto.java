package br.com.alura.util.Domain.Produto;

import java.math.BigDecimal;

import br.com.alura.util.Domain.Categoria.Categoria;
import br.com.unicommerce.Service.PrecoInvalidoException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "unicommerce", name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"produtoId"})
@Getter
@Setter
@ToString
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
	private BigDecimal preco;
	
	// ==================== Variaveis de Relacionamento================
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoriaId;

	// ==================== Variaveis de Relacionamento================

	public Produto(@Valid DadosCadastroProdutoDTO dados, Categoria categoria) {
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.quantidadeEstoque = dados.quantidadeEstoque();
		this.preco = dados.preco(); 
		this.categoriaId = categoria;
	} 
  
 
	
	 
	public void setPreco(BigDecimal preco) {
		if (preco.compareTo( new BigDecimal("0.00")) <= 0) {
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a 0.");
        }
		this.preco = preco;
	}




 
	
	
}
