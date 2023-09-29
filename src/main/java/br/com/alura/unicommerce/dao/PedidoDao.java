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
	
	
	public Pedido buscaPorId(Long id) {
        if (id == null) throw new IllegalArgumentException();
        Pedido encontrado = em.find(Pedido.class, id);
        return encontrado;
    }

    public void cadastra(Pedido pedido) {
        em.persist(pedido);
    }

    public void atualiza(Pedido pedido) {
        em.merge(pedido);
    }

    public void remove(Pedido pedido) {
        em.remove(pedido);
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
	
	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
}
