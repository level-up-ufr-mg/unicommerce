package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;

public record ProdutoCategoriaDTO(String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque, Categoria categoria) {

	public ProdutoCategoriaDTO(Produto entity, Categoria categoria) {
		this(entity.getNome(), entity.getDescricao(), entity.getPreco(), entity.getQuantidadeEstoque(), categoria);
	}

}
