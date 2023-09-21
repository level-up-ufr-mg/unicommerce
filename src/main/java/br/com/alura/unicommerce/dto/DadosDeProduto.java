package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosDeProduto(
		
		@NotNull
		Long id,
		
		@Positive
		int  quantidade,
		
		BigDecimal desconto,
		
		String tipoDesconto) {

	public ItemDePedido converter(ProdutoService produtoService) {
		
		Optional<Produto> produto = produtoService.buscaPorId(id);
		
		if(produto.isPresent()){
			
			ItemDePedido item = new ItemDePedido(quantidade, produto.get(), desconto, TipoDescontoItemPedido.valueOf(tipoDesconto));
			return item;
		}
		return null;
		
		
	}

}
