package br.com.alura.unicommerce.Dao;

import java.util.List;

import br.com.alura.unicommerce.VO.RelatorioClientesFieisVO;
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
	

	public List<RelatorioClientesFieisVO> relatorioClientesFiesVOs() {
	    String jpql = "SELECT NEW br.com.alura.unicommerce.VO.RelatorioClientesFieisVO ("
	            + "pedido.cliente.nome,"
	            + "SUM(item.quantidade) AS quantidade,"
	            + "SUM(item.quantidade * (item.precoUnitario - item.descontoId)) AS totalGasto)"
	            + "FROM Pedido AS pedido "
	            + "JOIN pedido.itens AS item "
	            + "JOIN item.produtoId AS produto "
	            + "JOIN produto.categoriaId AS categoria "
	            + "GROUP BY pedido.cliente.nome "
	            + "ORDER BY totalGasto DESC";

	    return em.createQuery(jpql, RelatorioClientesFieisVO.class).getResultList();
	}

	
}
