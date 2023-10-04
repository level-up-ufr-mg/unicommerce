package br.com.alura.unicommerce.record;

import java.math.BigDecimal;

import br.com.alura.unicommerce.modelo.Produto;

public record DadosListaDeProdutos(
		String nome, BigDecimal preco, String descricao, Integer quantidadeEstoque, Long categoriaId, String nomeCategoria ) {
	
	//Contrutor da record para receber um objeto de Produto
	public DadosListaDeProdutos(Produto p) {
		this(p.getNome(), p.getPreco(), p.getDescricao(), p.getQuantidadeEstoque(), p.getCategoria().getId(), p.getCategoria().getNome());
		
	}

}
