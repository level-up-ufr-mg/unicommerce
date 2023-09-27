package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(
		@NotBlank(message = "nome.obrigatorio")
		String nome, 
		
		@NotNull(message = "{descricao.obrigatorio}")
		String descricao,
		
		BigDecimal preco, 
		
		Integer quantidadeEstoque,
		
		Categoria categoria) {

	public ProdutoDTO(Produto entity) {
		this(entity.getNome(), entity.getDescricao(), entity.getPreco(), entity.getQuantidadeEstoque(), entity.getCategoria());
	}

}
