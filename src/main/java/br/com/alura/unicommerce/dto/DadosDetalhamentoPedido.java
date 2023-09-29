package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;

public record DadosDetalhamentoPedido(
		
		Cliente cliente,
		
		List<ItemDePedido> itens,
		
		BigDecimal valorTotal ) {

	public DadosDetalhamentoPedido(Pedido pedido) {
		this(pedido.getCliente(), pedido.getItens(), pedido.getValorTotal());
	}
	
	
}
