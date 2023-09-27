package br.com.alura.util.Domain.ItemPedido;

import java.math.BigDecimal;

import br.com.alura.util.Domain.Endereco.Descontos;
import br.com.alura.util.Domain.Pedido.Pedido;
import br.com.alura.util.Domain.Produto.Produto;
import jakarta.validation.constraints.NotNull;

public record ItenPedidoDTO(
		@NotNull
		Long ItenPedidoId,
		
		@NotNull
		BigDecimal precoUnitario,
		
		@NotNull
		Long quantidade,
		
		@NotNull
		Descontos tioDescontos,
		
		@NotNull
		BigDecimal descontos,
		
		@NotNull
		Pedido pedidoId,
		
		@NotNull
		Produto produtoId
		) {

}
