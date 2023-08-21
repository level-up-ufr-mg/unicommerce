package br.com.alura.unicommerce.Controller;

import java.util.List;

import br.com.alura.unicommerce.Dao.CategoriaDao;
import br.com.alura.unicommerce.Factory.Factory;
import br.com.alura.unicommerce.entidades.Categoria;
import jakarta.persistence.EntityManager;

//service 
public class CategoriaController {

	public static void main(String[] args) {
		Categoria celulares = new Categoria(null, "teste", "aaaaaaaa"); // transit

		EntityManager em = Factory.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);

//		Cadastra(celulares, em);
//
//		Editar(celulares, em);
//
//		Delete(celulares, em, categoriaDao); 
//		
//		
		buscaPorID(categoriaDao);
	
		
		BuscarTodos(categoriaDao);
		
		ListaporNome(categoriaDao); 

	}

	private static void buscaPorID(CategoriaDao categoriaDao) {
		Categoria c = categoriaDao.buscaProID(1L);
		System.out.print(c.getID()+" - "+c.getNOME()+" - "+ c.getSTATUS()+" \n \n ");
	}
	
	
	private static void  BuscarTodos(CategoriaDao categoriaDao) {
		 List<Categoria> buscarTodos = categoriaDao.BuscarTodos();
		 buscarTodos.forEach(c -> System.out.print(c.getID()+" - "+c.getNOME()+" - "+ c.getSTATUS()+" \n \n ") );
	}	
	
	private static void ListaporNome(CategoriaDao categoriaDao) {
		List<Categoria> listaporNome = categoriaDao.listaPorNomesClientes();
		listaporNome.forEach(c -> System.out.print(c.getID()+" - "+c.getNOME()+" \n\n"));
		
	}
	
	private static void Delete(Categoria celulares, EntityManager em, CategoriaDao categoriaDao) {
		em.getTransaction().begin();// inicio

		em.persist(celulares);// a entidade oi reconhecida

		// ===============================================
		categoriaDao.remover(celulares);
		// OU
		// em.remove(celulares);// reuisição ao banco de dados
		// ===============================================

		em.flush();// ou .commit() // para enviar ao banco de dados
	}

	private static void Editar(Categoria celulares, EntityManager em) {
		em.getTransaction().begin(); // inicio

		em.persist(celulares);// a entidade oi reconhecida

		celulares.setNOME("test");

		// em.flush();// ou .commit() // para enviar ao banco de dados

		em.getTransaction().commit();
		em.close(); // termino
	}

	private static void Cadastra(Categoria celulares, EntityManager em) {
		// +++ CADASTRA ++
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin(); // iniio

		categoriaDao.cadastra(celulares); // chama o metodo cadastrar onde esta o parametro percist

		em.getTransaction().commit();

		em.close(); // termino
	}
}
