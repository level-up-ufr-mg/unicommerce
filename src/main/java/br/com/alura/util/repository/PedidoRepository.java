package br.com.alura.util.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.util.domain.pedido.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	
//	@Query("SELECT DISTINCT p " +
//	           "FROM Pedido p " +
//	           "INNER JOIN p.cliente c " +
//	           "INNER JOIN p.itens i " +
//	           "INNER JOIN i.produtoId pr " +
//	           "INNER JOIN pr.categoriaId " +
//	           "WHERE p.pedidoId = :pedidoId")
//	    Page<Pedido> detalhamentoDePedido(@Param("pedidoId") Long pedidoId, Pageable pageable);
//	
	
	@Query("SELECT DISTINCT ped FROM Pedido ped " +
		       "INNER JOIN ped.cliente c " +
		       "INNER JOIN ped.itens item " +
		       "INNER JOIN item.produtoId prod " +
		       "INNER JOIN prod.categoriaId " +
		       "WHERE c.id = :pedidoId") // Usando c.id em vez de ped.cliente = :pedidoId
		Page<Pedido> DetalhamentoDePedido(@Param("pedidoId") Long pedidoId, Pageable pageable);

	
	
//	
//	 private EntityManager  em;
//
//	public PedidoDao(EntityManager manager) {
//		this.em = manager;
//	}
//	 
//	public void cadastra (Pedido pedido) {
//		this.em.persist(pedido);
//	}
//	
// 
//	public void Atualizr(Pedido pedido) {
//		this.em.merge(pedido);
//	}
//
//	public void remover(Pedido pedido) {
//		pedido = this.em.merge(pedido);
//		this.em.remove(pedido);
//	}
//	
//
//	public List<RelatorioClientesFieisVO> relatorioClientesFiesVOs() {
//	    String jpql = "SELECT NEW br.com.alura.unicommerce.VO.RelatorioClientesFieisVO ("
//	            + "pedido.cliente.nome,"
//	            + "SUM(item.quantidade) AS quantidade,"
//	            + "SUM(item.quantidade * (item.precoUnitario - item.descontoId)) AS totalGasto)"
//	            + "FROM Pedido AS pedido "
//	            + "JOIN pedido.itens AS item "
//	            + "JOIN item.produtoId AS produto "
//	            + "JOIN produto.categoriaId AS categoria "
//	            + "GROUP BY pedido.cliente.nome "
//	            + "ORDER BY totalGasto DESC";
//
//	    return em.createQuery(jpql, RelatorioClientesFieisVO.class).getResultList();
//	}
//
//	
}
