package br.com.alura.unicommerce.record;

import java.util.Optional;

import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
