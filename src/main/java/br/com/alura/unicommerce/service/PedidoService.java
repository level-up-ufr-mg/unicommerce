package br.com.alura.unicommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private PedidoDao dao;
	
	public void cadastra(Pedido pedido) {
		
		//VALIDAÇÃO DO DESCONTO QUANDO CLIENTE FEZ MAIS DE 5 PEDIDOS
			
		aplicarPoliticaDeDesconto(pedido);
		
		repository.save(pedido);
	}

	private void aplicarPoliticaDeDesconto(Pedido pedido) {
		
		Integer quantidadeDePedidos = 6;//aqui tem q buscar quanto pedidos tem para o cliente
		
		pedido.aplicaPoliticaDeDesconto(quantidadeDePedidos);
		
	}

}
