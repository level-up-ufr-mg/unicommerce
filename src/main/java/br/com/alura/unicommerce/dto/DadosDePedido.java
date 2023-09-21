package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.modelo.TipoDesconto;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;

public record DadosDePedido(Long clienteId, 
		String tipoDesconto, 
		BigDecimal desconto,
		@NotNull BigDecimal totalPedido,
		@NotNull List<DadosDeProduto> produtos

) {

	
	public Pedido converter(ClienteService clienteService, ProdutoService produtoService) {
		
		Optional<Cliente> cliente = clienteService.buscaPorId(clienteId);
		List<ItemDePedido> itens = produtos.stream().map(produto -> produto.converter(produtoService)).toList();
		
		System.out.println(cliente);
		
		if (cliente.isPresent()) 
			return new Pedido(cliente.get(), TipoDesconto.valueOf(tipoDesconto), desconto, itens);
		
		return null;
	}

}
