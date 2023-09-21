package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.vo.RelatorioDeVendasCategoriaVo;
import br.com.alura.unicommerce.vo.RelatorioDeVendasClienteVo;
import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;
import br.com.alura.unicommerce.vo.RelatorioProdutoVendidosMaisTresVezesVo;
import jakarta.persistence.EntityManager;

public class PedidoDao {

	
	  public PedidoDao() { }
	  
	  private EntityManager em;
	  
	  public PedidoDao(EntityManager em) { this.em = em; }
	  
	  public void cadastrar(Pedido pedido) { this.em.persist(pedido); }
	  
	  public void atualizar(Pedido pedido) { this.em.merge(pedido); }
	  
	  public void remover(Pedido pedido) { pedido = em.merge(pedido);
	  this.em.remove(pedido); }
	  
	  public Pedido buscarPorId(Long id) { return em.find(Pedido.class, id); }
	  
	  public List<Pedido> buscarTodos() { String jpql = "SELECT p FROM Pedido p";
	  return em.createQuery(jpql, Pedido.class).getResultList(); }
	  
	  public BigDecimal valorTotalVendido() { String jpql =
	  "SELECT SUM(p.valorTotal) FROM Pedido p"; return em.createQuery(jpql,
	  BigDecimal.class) .getSingleResult(); }
	  
	  public List<RelatorioDeVendasVo> relatorioDeVendas() { String jpql =
	  "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasVo(" +
	  "produto.nome, " + "SUM(item.quantidade) AS quantidade, " +
	  "MAX(pedido.data)) " + "FROM Pedido pedido " + "JOIN pedido.itemPedidos item " +
	  "JOIN item.produto produto " + "GROUP BY produto.nome " +
	  "ORDER BY quantidade DESC "; return em.createQuery(jpql,
	  RelatorioDeVendasVo.class) .getResultList(); }
	  
	  public Pedido buscaPedidoComCliente(Long id) { String jpql =
	  "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id "; return
	  em.createQuery(jpql, Pedido.class) .setParameter("id", id)
	  .getSingleResult(); }
	  
	  public List<RelatorioDeVendasClienteVo> relatorioDeVendasClientesFieis() {
	  String jpql =
	  "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasClienteVo(" +
	  "cliente.nome, " + "SUM(item.quantidade) AS quantidade, " +
	  "SUM(item.quantidade * (item.precoUnitario - item.desconto)) as montante) " +
	  "FROM Pedido pedido " + "JOIN pedido.itens item " +
	  "JOIN item.produto produto " + "JOIN pedido.cliente cliente " +
	  "GROUP BY cliente.nome " + "ORDER BY quantidade DESC "; return
	  em.createQuery(jpql, RelatorioDeVendasClienteVo.class) .setMaxResults(3)
	  .getResultList(); }
	  
	  public List<RelatorioDeVendasCategoriaVo> relatorioDeVendasPorCategoria() {
	  String jpql =
	  "SELECT new br.com.alura.unicommerce.vo.RelatorioDeVendasCategoriaVo(" +
	  "categoria.nome, " + "SUM(item.quantidade) as quantidade, " +
	  "SUM(item.quantidade * (item.precoUnitario - item.desconto)) as montante) " +
	  "FROM Pedido pedido " + "JOIN pedido.itens item " +
	  "JOIN item.produto produto " + "JOIN produto.categoria categoria " +
	  "GROUP BY categoria.nome " + "ORDER BY montante DESC "; return
	  em.createQuery(jpql, RelatorioDeVendasCategoriaVo.class) .getResultList(); }
	  
	  public List<RelatorioProdutoVendidosMaisTresVezesVo>
	  buscarProdutosVendidosMaisTresVezes() 
	  { String jpql = "SELECT new br.com.alura.unicommerce.vo.RelatorioProdutoVendidosMaisTresVezesVo( "
	  + " produto.nome, " + " COUNT(item.quantidade) AS quantidade) " +
	  " FROM Pedido pedido " + " JOIN pedido.itens item " +
	  "	JOIN item.produto produto " + "	GROUP BY produto.nome " +
	  " HAVING COUNT(item.quantidade) > 3"; 
	  return em.createQuery(jpql,
	  RelatorioProdutoVendidosMaisTresVezesVo.class) .getResultList(); }
	 
	
}
