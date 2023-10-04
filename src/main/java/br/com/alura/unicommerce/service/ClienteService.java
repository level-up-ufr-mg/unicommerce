package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.unicommerce.Relatorios.RelatorioDeVendasPorClienteVo;
import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.modelo.Pedido;

public class ClienteService {
	
	private PedidoDao pedidoDao = new PedidoDao();
	
	public List<RelatorioDeVendasPorClienteVo> getRelatorioDeVendasPorClienteVos() {
		return pedidoDao.relatorioDeVendas();
	}

	public List<RelatorioDeVendasPorClienteVo> getRelatorioClientesFieis(List<Pedido> pedidos) {
		List<RelatorioDeVendasPorClienteVo> relatorioDeVendasPorClienteVo = new ArrayList<>();

		pedidos.forEach(pedido -> {
			relatorioDeVendasPorClienteVo.add(
					new RelatorioDeVendasPorClienteVo(pedido.getCliente().getNome(), 1l, pedido.getValorTotal()));
		});
		
		return relatorioDeVendasPorClienteVo;
	}

}
