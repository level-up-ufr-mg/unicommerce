package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.relatorios.RelatorioClientesFieis;

public class ClienteService {
	
	private PedidoDao pedidoDao = new PedidoDao();

	public List<RelatorioClientesFieis> getRelatorioClientesFieis(List<Pedido> pedidos) {
		
		List<RelatorioClientesFieis> relatorioClientesFieis = new ArrayList<>();
		
		pedidos.forEach(pedido -> {
			relatorioClientesFieis.add(
					new RelatorioClientesFieis(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});
		
		return relatorioClientesFieis;
	}

	public PedidoDao getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

}
