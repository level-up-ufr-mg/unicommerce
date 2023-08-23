package br.com.alura.unicommerce.Dao;

import br.com.alura.unicommerce.modelo.Pedido;
import jakarta.persistence.EntityManager;

public class PedidoDao {

	
	
	 private EntityManager  em;

	public PedidoDao(EntityManager manager) {
		this.em = manager;
	}
	 
	public void cadastra (Pedido pedido) {
		this.em.persist(pedido);
	}
	

	public void Atualizr(Pedido pedido) {
		this.em.merge(pedido);
	}

	public void remover(Pedido pedido) {
		pedido = this.em.merge(pedido);
		this.em.remove(pedido);
		
		
	}
	
}
