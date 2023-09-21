package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;

public record DadosCadastraPedido(
		
		@NotNull
		Long clienteId,
		
		String tipoDesconto, 
		
		BigDecimal desconto,
		
		@NotNull
		BigDecimal totalPedidos,
		
		@NotNull
		List<DadosDeProduto> produtos) {
	
	public Pedido converter(ClienteService clienteService, ProdutoService produtoService) {
		
		Optional<Cliente> cliente = clienteService.buscaPorId(clienteId);
		List<ItemDePedido> itens = produtos.stream().map(produto -> produto.converter(produtoService)).toList();
		if (cliente.isPresent()) {
			
		Pedido novoPedido = new Pedido(cliente.get(), itens, desconto,
				TipoDescontoPedido.valueOf(tipoDesconto));
		return novoPedido;
		}
		return null;
		
	}

}
