package br.com.alura.unicommerce.record;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.ItemDePedido;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.service.ClienteService;
import br.com.alura.unicommerce.service.ProdutoService;

public record DadosCadastroPedido(
		
		@NotNull
		Long clienteId,
		@NotNull
		List<DadosDeProduto> produtos) {

	public Pedido converter(ClienteService clienteService, ProdutoService produtoService) {

		List<DadosDeProduto> produtos = new ArrayList<>();
		
		Optional<Cliente> cliente = clienteService.buscaPorId(clienteId);
		List<ItemDePedido> itens = produtos.stream().map(produto -> produto.converter(produtoService)).toList(); //faz o mapeamento e passa para uma lista
		
		if(cliente.isPresent()) {
			return new Pedido(cliente.get(), itens); //Dados da requisição no Postman
		}
		
		return null;
	}
}
