package br.com.alura.unicommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.relatorios.RelatorioClientesFieis;
import br.com.alura.unicommerce.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private PedidoDao pedidoDao = new PedidoDao();
	
	@Autowired
	private ClienteRepository repository;

	public List<RelatorioClientesFieis> getRelatorioClientesFieis(List<Pedido> pedidos) {
		
		List<RelatorioClientesFieis> relatorioClientesFieis = new ArrayList<>();
		
		pedidos.forEach(pedido -> {
			relatorioClientesFieis.add(
					new RelatorioClientesFieis(pedido.getCliente().getNome(), 1L, pedido.getValorTotal()));
		});
		
		return relatorioClientesFieis;
	}
	
	
	public void atualizar(Cliente obj) {
		//if(obj == null)
			//throw new ClienteException("Atualização inválida para objeto nulo");
		repository.save(obj);
	}
	
	public Optional<Cliente> buscaPorId(Long clienteId){
		return repository.findById(clienteId);
	}
	

	public PedidoDao getPedidoDao() {
		return pedidoDao;
	}

	public void setPedidoDao(PedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}

}
