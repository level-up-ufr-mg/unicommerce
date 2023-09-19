package br.com.alura.util.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

	
	 
	
	
	
	
	
	
	
	
	
	
	
//	
//	 private EntityManager  em;
//
//	public ItemPedidoDao(EntityManager manager) {
//		this.em = manager;
//	} 
//	 
//	public void cadastra (ItemPedido Item_Pedido) {
//		this.em.persist(Item_Pedido);
//	} 
//	
//
//	public void Atualizr(ItemPedido Item_Pedido) {
//		this.em.merge(Item_Pedido);
//	}
//	public void remover (ItemPedido item_Pedido) {
//		item_Pedido = this.em.merge(item_Pedido);
//		this.em.remove(item_Pedido);
//	} 
//	 
//	 
//	public List<RelatorideVendasPorCategoriaVO> relatorideVendasPorCategoriaVO(){
//		String jpql = "SELECT NEW br.com.alura.unicommerce.VO.RelatorideVendasPorCategoriaVO("
//		        + "produto.nome, "
//		        + "SUM(iten.quantidade), "
//		        + "SUM(iten.precoUnitario)) "
//		        + "FROM ItemPedido iten "  
//		        + "JOIN iten.produtoId produto "
//		        + "GROUP BY produto.nome "
//		        + "ORDER BY MAX(iten.quantidade) DESC"; // usar MAX(iten.QUANTIDADE) para ordenar
//	    return em.createQuery(jpql, RelatorideVendasPorCategoriaVO.class).getResultList(); 
//	} 
//
//	public List<RelatorioDeItensMaisVendidosVO> relatorioDeItensMaisVendidosVOs() {
//	    String jpql = "SELECT NEW br.com.alura.unicommerce.VO.RelatorioDeItensMaisVendidosVO ("
//	            + "produto.nome, MAX(iten.quantidade))"
//	            + "FROM ItemPedido iten "
//	            + "JOIN iten.produtoId produto "
//	            + "GROUP BY produto.nome "
//	            + "HAVING MAX(iten.quantidade) > 3 "
//	            + "ORDER BY MAX(iten.quantidade) DESC";
//	    
//	    return em.createQuery(jpql, RelatorioDeItensMaisVendidosVO.class).getResultList();
//	}
//
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
