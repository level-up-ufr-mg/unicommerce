package br.com.alura.unicommerce.dao;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Pedido;

public class PedidoDao {
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}

	public void cadastra(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public Pedido buscaPorId(Long id) {
		String jpql = "SELECT c FROM Pedido c WHERE c.id = :id";
		return em.createQuery(jpql, Pedido.class)
				.setParameter("id", id)
				.getSingleResult();		
	}
}
