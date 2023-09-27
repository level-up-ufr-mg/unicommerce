package br.com.unicommerce.Service;

import java.util.Optional;

import br.com.alura.util.Domain.Cliente.Cliente;
import jakarta.validation.constraints.NotNull;

public class ClienteService {

	public Optional<Cliente> buscaPorId(@NotNull Long clienteId) {
		// TODO Auto-generated method stub
		return null;
	}

//	EntityManager em = Factory.getEntityManager();
//
//	private PedidoDao pedidoDao = new PedidoDao(em);
//	
//	
//	
//
//	public List<RelatorioClientesFieisVO> getRelatorioClientesFieis(List<Pedido> listaComUmPedido) {
//		List<RelatorioClientesFieisVO> relatorioClientesFieisVOs = new ArrayList();
//		
//		listaComUmPedido.forEach(pedido ->	
//		{relatorioClientesFieisVOs.add( new RelatorioClientesFieisVO(pedido.getCliente().getNome(),1L, pedido.getValorTotal())); 
//		
//		});
//		return relatorioClientesFieisVOs;
//	}



}