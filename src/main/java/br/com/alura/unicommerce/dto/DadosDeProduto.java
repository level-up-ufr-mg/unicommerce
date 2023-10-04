package br.com.alura.unicommerce.dto;

import java.util.Optional;

import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosDeProduto(
		
		@NotNull
		Long id,
		
		@Positive
		int  quantidade) {

	public ItemDePedido converter(ProdutoService produtoService) {
		
		Optional<Produto> produto = produtoService.buscaPorId(id);
		
		if(produto.isPresent()){
			
			ItemDePedido item = new ItemDePedido(quantidade, produto.get());
			return item;
		}
		return null;
		
		
	}

}
