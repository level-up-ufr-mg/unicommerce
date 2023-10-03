package br.com.alura.util.domain.pedido;

import java.math.BigDecimal;
import java.util.Date;

import br.com.alura.util.domain.cliente.Cliente;
import br.com.alura.util.domain.endereco.Descontos;

public record ListaDadosPedidoDTO(Long pedidoId , BigDecimal desconto , Descontos tipoDescontos, BigDecimal valorTotal ,Cliente cliente) {

	
	public ListaDadosPedidoDTO (Pedido pedido) {
		this(pedido.getPedidoId(),pedido.getDesconto(), pedido.getTipoDesconto(),pedido.getValorTotal() ,pedido.getCliente());
	}
	
}
