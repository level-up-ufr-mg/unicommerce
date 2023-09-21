package br.com.alura.unicommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.unicommerce.dao.PedidoDao;
import br.com.alura.unicommerce.modelo.Pedido;

@Service
public class PedidoService {

	@Autowired
	private PedidoDao pedidoDao;
	
	public void cadastra(Pedido pedido) {
		
		pedidoDao.cadastra(pedido);;
	}

}
