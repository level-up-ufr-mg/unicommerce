package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.modelo.TipoDescontoItemPedido;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosDeProduto(
		@NotNull
		Long id, 
		@Positive
		Integer quantidade 
		) {

	public ItemDePedido converter(ProdutoService produtoService) {
		Optional<Produto> produto = produtoService.findById(id);
		
		System.out.println(produto.toString());
		
		if(produto.isPresent()) 
			return new ItemDePedido(quantidade, produto.get()); 
			
		 return null;
		
	}

}
