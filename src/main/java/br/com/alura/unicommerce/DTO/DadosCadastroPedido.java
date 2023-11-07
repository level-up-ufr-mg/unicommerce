package br.com.alura.unicommerce.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.ItemPedido.ItemDePedido;
import br.com.alura.unicommerce.Domain.Pedido.Pedido;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPedido(

		@NotNull Long clienteId,

		@NotNull BigDecimal totalPedidos,

		@NotNull List<DadosDeProduto> produtos) {

	public Pedido converter(ClienteService clienteService, ProdutoService produtoService) {

		Optional<Cliente> cliente = clienteService.searchID(clienteId);
		List<ItemDePedido> itens = produtos.stream().map(produto -> produto.converter(produtoService)).toList();
		if (cliente.isPresent()) {
			Pedido novoPedido = new Pedido(cliente.get(), itens);
			return novoPedido;
		}
		return null;
	}
}