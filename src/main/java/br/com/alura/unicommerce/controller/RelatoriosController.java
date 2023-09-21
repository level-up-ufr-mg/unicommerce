//package br.com.alura.unicommerce.controller;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//
//import br.com.alura.unicommerce.dao.CategoriaDao;
//import br.com.alura.unicommerce.dao.ClienteDao;
//import br.com.alura.unicommerce.dao.PedidoDao;
//import br.com.alura.unicommerce.dao.ProdutoDao;
//import br.com.alura.unicommerce.modelo.Cliente;
//import br.com.alura.unicommerce.modelo.Produto;
//import br.com.alura.unicommerce.util.JPAUtil;
//import br.com.alura.unicommerce.vo.RelatorioClientesFiesVo;
//import br.com.alura.unicommerce.vo.RelatorioDeVendasVo;
//import br.com.alura.unicommerce.vo.RelatorioProdutosMaisVendidosVo;
//import br.com.alura.unicommerce.vo.RelatorioVendasPorCategoriaVo;
//
//public class RelatoriosController {
//	
//	
//	
//	public static void main(String[] args) {
//        
//		relatorioVendasPorCategoriaMetodo();
//		relatorioClientesFiesMetodo();
//		relatorioProdutosMaisVendidosMetodo();
//		
//    }
//	
//	
//		public static void  relatorioVendasPorCategoriaMetodo() {
//			
//			EntityManager em = JPAUtil.getEntityManager();
//	        CategoriaDao categoriaDao = new CategoriaDao(em);
//   
//	        List<RelatorioVendasPorCategoriaVo> relatorio = categoriaDao.relatorioVendasPorCategoria();
//			for (RelatorioVendasPorCategoriaVo relatorioItem : relatorio) {
//			    System.out.println(relatorioItem);
//			    
//			    
//			}
//	       em.close();
//			
//		}
//	
//		public static void  relatorioClientesFiesMetodo() {
//				
//				EntityManager em = JPAUtil.getEntityManager();
//		        ClienteDao clienteDao = new ClienteDao(em);
//
//		        List<RelatorioClientesFiesVo> relatorio = clienteDao.relatorioClientesFies();
//				for (RelatorioClientesFiesVo relatorioItem : relatorio) {
//				    System.out.println(relatorioItem);
//				    
//				    
//				}
//		       em.close();
//			
//		}
//		
//		
//		public static void relatorioProdutosMaisVendidosMetodo() {
//		    EntityManager em = JPAUtil.getEntityManager();
//		    ProdutoDao produtoDao = new ProdutoDao(em);
//		    
//		    List<RelatorioProdutosMaisVendidosVo> relatorio = produtoDao.relatorioProdutosMaisVendidos();
//			for (RelatorioProdutosMaisVendidosVo relatorioItem : relatorio) {
//			    System.out.println(relatorioItem);
//			    
//			    
//			}
//	       em.close();
//		    
//		}
//		
//		public static void RelatorioDeVendas() {
//			
//			EntityManager em = JPAUtil.getEntityManager();
//			
//			em.getTransaction().begin();
//			
//			PedidoDao pedidoDao = new PedidoDao(em);
//			
//			List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
//			for (RelatorioDeVendasVo relatorioItem : relatorio) {
//			    System.out.println(relatorioItem);
//			    
//			    
//			}
//		}
//}
