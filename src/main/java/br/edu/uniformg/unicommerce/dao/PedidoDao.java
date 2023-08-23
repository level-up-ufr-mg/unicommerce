package br.edu.uniformg.unicommerce.dao;

import javax.persistence.EntityManager;

import br.edu.uniformg.unicommerce.modelo.Pedido;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public Pedido buscaPorId(Long id) {
		return em.find(Pedido.class, id);
	}
	
	public void cadastra(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	
//	   public BigDecimal valorTotalVendido() {
//		         String jpql = " SELECT SUM(p.valorTotal) FROM Pedido p ";
//		         return em.createQuery(jpql, BigDecimal.class).getSingleResult();
//		         
//		     }
//		     
//		     public List<Object[]>  relatorioDeVendas() {
//		         String jpql = " SELECT produto.nome, SUM(item.quantidade), MAX(pedido.data)"
//		                     + " FROM Pedido pedido "
//		                     + " JOIN pedido.itens item "
//		                     + " JOIN item.produto produto "
//		                     + " GROUP BY produto.nome "
//		                     + " ORDER BY SUM(item.quantidade) DESC ";
//		         return em.createQuery(jpql, Object[].class ).getResultList();
//		         
//		     }
	
}
