package br.com.alura.util.domain.itemPedido;

import java.math.BigDecimal;

import br.com.alura.util.domain.endereco.Descontos;
import br.com.alura.util.domain.pedido.Pedido;
import br.com.alura.util.domain.produto.Produto;
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
