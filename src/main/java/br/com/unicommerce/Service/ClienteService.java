package br.com.unicommerce.Service;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.Dao.PedidoDao;
import br.com.alura.unicommerce.Util.Factory;
import br.com.alura.unicommerce.VO.RelatorioClientesFieisVO;
import jakarta.persistence.EntityManager;

public class ClienteService {

	EntityManager em = Factory.getEntityManager();

	private PedidoDao pedidoDao = new PedidoDao(em);
	
	
	

	public List<RelatorioClientesFieisVO> getRelatorioClientesFieis(List<Pedido> listaComUmPedido) {
		List<RelatorioClientesFieisVO> relatorioClientesFieisVOs = new ArrayList();
		
		listaComUmPedido.forEach(pedido ->	
		{relatorioClientesFieisVOs.add( new RelatorioClientesFieisVO(pedido.getCliente().getNome(),1L, pedido.getValorTotal())); 
		
		});
		return relatorioClientesFieisVOs;
	}



}