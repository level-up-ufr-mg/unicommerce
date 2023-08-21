package br.com.alura.unicommerce.Controller;

import java.util.List;

import javax.security.auth.x500.X500Principal;

import br.com.alura.unicommerce.Dao.CategoriaDao;
import br.com.alura.unicommerce.Dao.ProdutoDao;
import br.com.alura.unicommerce.Factory.Factory;
import br.com.alura.unicommerce.entidades.Categoria;
import br.com.alura.unicommerce.entidades.Produto;
import jakarta.persistence.EntityManager;

//service
public class ProdutoController {

	public static void main(String[] args) {
		Categoria categoria = new Categoria(null, "informatica", "ativada");
		Produto produto = new Produto(null, "computador", "intel", 10L, categoria);

		EntityManager em = Factory.getEntityManager();
		ProdutoDao produtodao = new ProdutoDao(em);
		CategoriaDao categoriadao = new CategoriaDao(em);

//		Cadastrar(categoria, produto, em, produtodao, categoriadao);
//
//		Editar(categoria, produto, em);
//
//		Delete(categoria, produto, em);
//
//		ListaIndisponiveis(produtodao);

		BuscaporId(produtodao);
		
		BuscarTodos(produtodao);
		
	}

	private static void ListaIndisponiveis(ProdutoDao produtoDao) {
		List<Produto> listaPorNomesClientes = produtoDao.BuscaIndisponives("ATIVADO");// DESATIVADO
		listaPorNomesClientes.forEach(c -> System.out
				.print("\n\n ID : " + c.getID() + "\n - Nome :  " + c.getNOME() + "\n - Descrição : " + c.getDESCRICAO()
						+ "\n - Quantidade : " + c.getQUANTIDADE_ESTOQUE() + "\n  " + c.getCATEGORIA_ID() + "\n\n"));

	}

	private static void BuscarTodos(ProdutoDao produtoDao) {
		List<Produto>buscarTodos = produtoDao.BuscarTodos();
		buscarTodos.forEach(c -> System.out
				.print("\n\n ID : " + c.getID() + "\n - Nome :  " + c.getNOME() + "\n - Descrição : " + c.getDESCRICAO()
						+ "\n - Quantidade : " + c.getQUANTIDADE_ESTOQUE() + "\n  " + c.getCATEGORIA_ID() + "\n\n"));
		
	}
	
	private static void BuscaporId(ProdutoDao produtoDao) {
		Produto p = produtoDao.buscaProID(1L);
		System.out.print(
				("\n\n ID : " + p.getID() + "\n - Nome :  " + p.getNOME() + "\n - Descrição : " + p.getDESCRICAO()
						+ "\n - Quantidade : " + p.getQUANTIDADE_ESTOQUE() + "\n  " + p.getCATEGORIA_ID() + "\n\n"));

	}

	private static void Delete(Categoria categoria, Produto produto, EntityManager em) {
		// DELETE

		em.getTransaction().begin();// inicio

		em.persist(categoria); // persist
		em.persist(produto);

		em.remove(produto);// porque invertendo a odem dos REMOVE ele aparece um update
		em.remove(categoria);

		em.flush();// ou .commit
	}

	private static void Cadastrar(Categoria categoria, Produto produto, EntityManager em, ProdutoDao produtodao,
			CategoriaDao categoriadao) {
		// +++ Cadastra +++
		em.getTransaction().begin();

		categoriadao.cadastra(categoria);
		produtodao.cadastra(produto);

		em.getTransaction().commit();
		em.close();
	}

	private static void Editar(Categoria categoria, Produto produto, EntityManager em) {
		// +++ EDITAR++++
		em.getTransaction().begin(); // inicio

		em.persist(categoria); // percist
		em.persist(produto);

		categoria.setNOME("unifor");

		// em.flush();// para sincronizar ao BD sem fazer o comitt

		em.getTransaction().commit();
		em.close(); // termino
	}

}
