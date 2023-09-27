package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;

public record DadosListagemProduto(String nome, BigDecimal preco, String descricao, Integer quantidadeEstoque, Categoria categoria) {

	/*
	 * public DadosListagemProduto(Produto dados) { this(dados.getNome(),
	 * dados.getNome(), dados.getDescricao(), dados.getQuantidadeEstoque(),
	 * dados.categoria); }
	 */

}
