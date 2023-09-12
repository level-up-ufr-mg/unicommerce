package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.relatorios.RelatorioVendasPorCatergoria;

//Para criar o método de pegar o relatório de vendas por categoria
public class CategoriaService {
	
	private PedidoDao pedidoDao = new PedidoDao();


	public List<RelatorioVendasPorCatergoria> getRelatorioVendasPorCatergoria(List<Pedido> pedidos) {
		
		List<RelatorioVendasPorCatergoria> relatorioVendasPorCatergoria = new ArrayList<>();
		
		
		pedidos.forEach(pedido -> {
			relatorioVendasPorCatergoria.add(
					new RelatorioVendasPorCatergoria(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});
		
		return relatorioVendasPorCatergoria;
	}

	public PedidoDao getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

}
