package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ClienteDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class RelatoriosController {
	
	
	
	public static void main(String[] args) {
        
		relatorioVendasPorCategoriaMetodo();
		relatorioClientesFiesMetodo();
		relatorioProdutosMaisVendidosMetodo();
		
    }
	
	
		public static void  relatorioVendasPorCategoriaMetodo() {
			
			EntityManager em = JPAUtil.getEntityManager();
	        CategoriaDao categoriaDao = new CategoriaDao(em);
	
	        List<Object[]> relatorio = categoriaDao.relatorioVendasPorCategoria();
	        for (Object[] row : relatorio) {
	            String nomeCategoria = (String) row[0];
	            Long quantidadeVendida = (Long) row[1];
	            BigDecimal montanteVendido = (BigDecimal) row[2];
	
	            System.out.println("--------------------------");
	            System.out.println("Categoria: " + nomeCategoria);
	            System.out.println("Quantidade vendida: " + quantidadeVendida);
	            System.out.println("Montante vendido: " + montanteVendido);
	            System.out.println("--------------------------");
	        }
	       em.close();
			
		}
	
		public static void  relatorioClientesFiesMetodo() {
				
				EntityManager em = JPAUtil.getEntityManager();
		        ClienteDao clienteDao = new ClienteDao(em);
		
		        List<Object[]> relatorio = clienteDao.relatorioClientesFies();
		
		        for (Object[] resultado : relatorio) {
		            String nomeCliente = (String) resultado[0];
		            Long quantidadePedidos = (Long) resultado[1];
		            BigDecimal montanteGasto = (BigDecimal) resultado[2];
		
		            System.out.println("-------------------------");
		            System.out.println("Cliente: " + nomeCliente);
		            System.out.println("Quantidade de pedidos: " + quantidadePedidos);
		            System.out.println("Montante gasto: " + montanteGasto);
		            System.out.println("-------------------------");
		        }
		
		        em.close();
			
		}
		
		
		public static void relatorioProdutosMaisVendidosMetodo() {
		    EntityManager em = JPAUtil.getEntityManager();
		    ProdutoDao produtoDao = new ProdutoDao(em);

		    List<String> relatorio = produtoDao.relatorioProdutosMaisVendidos();

		    for (String produto : relatorio) {
		    	System.out.println("-------------------------");
		        System.out.println("Produto: " + produto);
		        System.out.println("-------------------------");
		    }
		}
}
