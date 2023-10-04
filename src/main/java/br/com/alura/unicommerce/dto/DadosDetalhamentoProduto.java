package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;

public record DadosDetalhamentoProduto(
		
		String nome,
		
		String descricao,
		
		Integer quantidadeEstoque,
		
		Categoria categoria,
		
		BigDecimal preco) {

	
	public DadosDetalhamentoProduto (Produto produto) {
		this(produto.getNome(), produto.getDescricao(), produto.getQuantidadeEstoque(), produto.getCategoria(), produto.getPreco());
	}
	
}
