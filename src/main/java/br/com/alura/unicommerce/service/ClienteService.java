package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;

public class ClienteService {

	public List<RelatorioClientesFiesVo> getRelatorioClienteFieis(List<Pedido> listaDePedidos) {
		
		List<RelatorioClientesFiesVo> relatorioClientesFieis = new ArrayList<>();
		
		listaDePedidos.forEach(pedido -> {
			relatorioClientesFieis.add(
				new RelatorioClientesFiesVo(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});
		
	    return relatorioClientesFieis;
	}
}
