package br.com.alura.unicommerce.record;

import java.util.Optional;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.service.ProdutoService;

public record DadosDeProduto(

		@NotNull Long id,

		@NotNull 
		@Positive 
		Integer quantidadeVendida) {

	// Converte um item por vez para depois montar a lista
	public ItemDePedido converter(ProdutoService produtoService) {

		Optional<Produto> produto = produtoService.buscaPorId(id);

		if (produto.isPresent())
			return new ItemDePedido(produto.get(), quantidadeVendida);

		return null;

	}
}
