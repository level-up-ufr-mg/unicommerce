package br.com.alura.unicommerce.DTO;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.ItemPedido.ItemDePedido;
import br.com.alura.unicommerce.Domain.Pedido.Pedido;

public record DadosDetalhamentoPedido(
		Cliente cliente,
		List<ItemDePedido> itens,
		BigDecimal valorTotal ) {
	public DadosDetalhamentoPedido(Pedido pedido) {
		this(pedido.getCliente(), pedido.getItens(), pedido.getValorTotal());
	}
}