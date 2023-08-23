package br.edu.uniformg.unicommerce.service;

//import javax.persistence.EntityManager;
//
//import br.edu.uniformg.unicommerce.dao.CategoriaDao;
//import br.edu.uniformg.unicommerce.dao.ProdutoDao;
//import br.edu.uniformg.unicommerce.modelo.Categoria;
//import br.edu.uniformg.unicommerce.modelo.Produto;
//import br.edu.uniformg.unicommerce.util.JPAUtil;
//
//public class ProdutoService {
//
//	public static void main (String[] args) {
//		
//		Produto prod = new Produto();
//		
//		EntityManager em = JPAUtil.getEntityManager();
//		ProdutoDao prodDao = new ProdutoDao(em);
//		
//		em.getTransaction().begin();
//		prodDao.cadastrarProduto(prod);
//		em.getTransaction().commit();
//		em.close();
//	}
//}
