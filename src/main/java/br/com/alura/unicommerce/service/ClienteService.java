package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.vo.RelatorioDeVendasClienteVo;

public class ClienteService {
	
	public List<RelatorioDeVendasClienteVo> getRelatorioClientesFieis(List<Pedido> pedidos) {
		
		List<RelatorioDeVendasClienteVo> relatorioClientesFieis = new ArrayList<>();
		
		pedidos.forEach(pedido -> {
			relatorioClientesFieis.add(
					new RelatorioDeVendasClienteVo(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});
		
		return relatorioClientesFieis;
	}

}
