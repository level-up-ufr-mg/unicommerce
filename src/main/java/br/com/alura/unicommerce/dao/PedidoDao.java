package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;

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
		return em.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal valorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}

	public List<RelatorioDeVendasVo> relatorioDeVendas(){
		String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasVo("
				+ "produto.nome, "
				+ "SUM(item.quantidade), "
				+ "MAX(pedido.data)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itens item "
				+ "JOIN item.produto produto "
				+ "GROUP BY produto.nome, item.quantidade, pedido.data "
				+ "ORDER BY item.quantidade DESC ";
		return em.createQuery(jpql, RelatorioDeVendasVo.class)
				.getResultList();
	}
}
