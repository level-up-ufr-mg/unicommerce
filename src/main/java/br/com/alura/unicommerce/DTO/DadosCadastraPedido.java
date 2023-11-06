package br.com.alura.unicommerce.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.alura.unicommerce.Domain.TipoDescontoPedido;
import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.Pedido.Pedido;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.ProdutoService;
import jakarta.validation.constraints.NotNull;

public record DadosCadastraPedido(@NotNull Long clienteId, TipoDescontoPedido tipoDesconto, BigDecimal desconto,
		@NotNull BigDecimal totalPedidos, @NotNull List<DadosDeProduto> produtos) {

	public Pedido converter(ClienteService clienteService, ProdutoService produtoService) {

		Optional<Cliente> cliente = clienteService.buscaPorId(clienteId);
		System.out.println(cliente);
		return null;
	}
}