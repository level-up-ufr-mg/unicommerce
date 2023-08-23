package br.edu.uniformg.unicommerce.service;

//import javax.persistence.EntityManager;
//import br.edu.uniformg.unicommerce.dao.CategoriaDao;
//import br.edu.uniformg.unicommerce.modelo.Categoria;
//import br.edu.uniformg.unicommerce.util.JPAUtil;
//
//public class CatergoriaService {
//	
//	
//	//Testa método para cadastrar Categoria
//	public static void main (String[] args) {
//		
//		Categoria cat = new Categoria();
//		
//		EntityManager em = JPAUtil.getEntityManager();
//		CategoriaDao catDao = new CategoriaDao(em);
//		
//		//Inserir os demais métodos da classe CategoriaDao
//		
//		em.getTransaction().begin();
//		catDao.listarCategorias();
//		em.getTransaction().commit();
//		em.close();
//		
//		em.getTransaction().begin();
//		catDao.cadastrarCategoria(cat);
//		em.getTransaction().commit();
//		em.close();
//		
//		
//		
//		
//	}
//	
//}
