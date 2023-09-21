package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.modelo.Produto;


public record DadosListagemProduto(
		
		String nome, 
		
		BigDecimal preco,
		
		String descricao,
		
		Integer quantidadeEstoque,
		
		Long categoria,
		
		String categoriaNome) {
	
	public DadosListagemProduto(Produto produto) {
		this(produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getQuantidadeEstoque(), produto.getCategoria().getId(), produto.getCategoria().getNome());
	}

	


}
