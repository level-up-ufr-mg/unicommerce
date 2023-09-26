package br.com.alura.util.Domain.Produto;

import java.math.BigDecimal;

import br.com.alura.util.Domain.Categoria.Categoria;

public record ListaDadosProdutoDTO(
		Long id, String nome,String descricao, Long quantidadeEstoque, BigDecimal preco, Categoria categoria) {
	
	public ListaDadosProdutoDTO (Produto produto) {
		this(produto.getProdutoId(), produto.getNome(),produto.getDescricao(), produto.getQuantidadeEstoque(),produto.getPreco(),
				produto.getCategoriaId());
	}
	

}
