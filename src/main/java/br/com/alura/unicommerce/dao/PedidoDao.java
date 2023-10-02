package br.com.alura.unicommerce.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.unicommerce.modelo.Pedido;
import br.com.alura.unicommerce.relatorios.RelatorioClientesFieis;
import br.com.alura.unicommerce.relatorios.RelatorioProdutosVendidosMaisDe3x;
import br.com.alura.unicommerce.relatorios.RelatorioVendas;
import br.com.alura.unicommerce.relatorios.RelatorioVendasPorCatergoria;
import jakarta.persistence.EntityManager;




public class PedidoDao {

	private EntityManager em;
	
	public PedidoDao() {
		
	}

    public PedidoDao(EntityManager em) {
        this.em = em;
    }
    
    public Pedido buscaPorId(Integer id) {
        return em.find(Pedido.class, id);
    }
    
    public void cadastra(Pedido pedido) {
        this.em.persist(pedido);
    }
	
    
    public BigDecimal valorTotalVendido() {
    	String jpql = " SELECT SUM(p.valorTotal) FROM Pedido p ";
    	return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    	
    }
    
    //Forma 2 - Forma simplificado com SELECT NEW por meio da classe RelatorioVendas
	public List<RelatorioVendas> relatorioDeVendas(){
		//Dá o new passando os dados para o Construtor
		String jpql = "SELECT new br.com.alura.unicommerce.relatorios.RelatorioVendas " + "( produto.nome, " + " SUM(item.quantidade), " + " MAX(pedido.data)) "				
				+ " FROM Pedido pedido "
				+ " JOIN pedido.itens item "
				+ " JOIN item.produto produto "
				+ " GROUP BY produto.nome "
				+ " ORDER BY SUM (item.quantidade) DESC ";	
		return em.createQuery(jpql, RelatorioVendas.class).getResultList();
	}
	
    
    
//	//Forma 1 - retorna lista de objetos
//    public List<Object[]>  relatorioDeVendas() {
//    	String jpql = " SELECT produto.nome, SUM(item.quantidade), MAX(pedido.data)"
//    			    + " FROM Pedido pedido "
//    			    + " JOIN pedido.itens item "
//    			    + " JOIN item.produto produto "
//    			    + " GROUP BY produto.nome "
//    			    + " ORDER BY SUM(item.quantidade) DESC ";
//    	return em.createQuery(jpql, Object[].class ).getResultList();
//    	
//    }
	
	public List<RelatorioVendasPorCatergoria> relatorioVendasPorCategoria(){
		//SELECT new -> qdo o retorno não é uma Entidade mapeada
		String jpql = "SELECT new br.com.alura.unicommerce.relatorios.RelatorioVendasPorCatergoria(categoria.nome, SUM (item.quantidade) As quantidadeProdutosVendidos, SUM (item.quantidade * (item.precoUnitario - item.desconto)) AS totalVendasCategoria) "
					+ " FROM Pedido AS pedido "
					+ " JOIN pedido.itens AS item" 
					+ " JOIN pedido.categoria AS categoria "
					+ " GROUP BY pedido.categoria.nome "
					+ " ORDER BY totalVendasCategoria DESC ";
		return em.createQuery(jpql, RelatorioVendasPorCatergoria.class).getResultList();
	}
	
	public List<RelatorioClientesFieis> relatorioClientesFieis(){
		
		String jpql = "SELECT new br.com.alura.unicommerce.relatorios.RelatorioClientesFieis(" 
				+ "pedido.cliente.nome, "
				+ "SUM(item.quantidade) AS quantidade, "
				+ "SUM(item.quantidade * (item.precoUnitario - item.desconto)) AS totalGasto) "
				+ "FROM Pedido AS pedido "
				+ "JOIN pedido.itens AS item " //Join de Pedido com ItemDePedido
				+ "JOIN item.produto AS produto " //Join de ItemDePedido com Produto
				+ "JOIN produto.categoria AS categoria " //Join de Produto com Categoria
				+ "GROUP BY pedido.cliente.nome " //Agrupar o total gasto e a quantidade de pedidos pelo cliente
				+ "ORDER BY totalGasto DESC ";
		return em.createQuery(jpql, RelatorioClientesFieis.class).getResultList();
	}

	public List<RelatorioProdutosVendidosMaisDe3x> buscaRelatorioProdutosVendidosMaisDe3x() {
		
		String jpql = "SELECT new br.com.alura.unicommerce.relatorios.RelatorioProdutosVendidosMaisDe3x(produto.nome, COUNT(item.quantidade)) "
				+ "FROM Pedido AS pedido "
				+ "JOIN pedido.itens AS item "
				+ "JOIN item.produto AS produto "
				+ "GROUP BY produto.nome "
				+ "HAVING COUNT(item.quantidade) > 3 "; //HAVING filtra grupo de resultados
		
		return em.createQuery(jpql, RelatorioProdutosVendidosMaisDe3x.class).getResultList();
	}

}
