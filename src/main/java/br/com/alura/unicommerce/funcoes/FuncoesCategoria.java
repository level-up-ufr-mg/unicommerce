package br.com.alura.unicommerce.funcoes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesCategoria {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		cadastra(em);
//		buscaPorId(em);
//		listaTodas(em);
	}

	private static void cadastra(EntityManager em) {

		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria categoria = new Categoria("Eletrônicos", true);
		Categoria categoria2 = new Categoria("Moda", true);
		Categoria categoria3 = new Categoria("Esportes", false);


		em.getTransaction().begin();
		categoriaDao.cadastra(categoria);
		categoriaDao.cadastra(categoria2);
		categoriaDao.cadastra(categoria3);
		em.getTransaction().commit();
		em.close();
	}

	private static void buscaPorId(EntityManager em) {
		CategoriaDao buscaPorId = new CategoriaDao(em);

		Categoria categoriasPorId = buscaPorId.buscaPorId(1L);
		System.out.print(categoriasPorId);
	}

	private static void listaTodas(EntityManager em) {
		CategoriaDao listaTodas = new CategoriaDao(em);

		List<Categoria> listaTodasCategorias = listaTodas.listaTodas();
		listaTodasCategorias.forEach(c -> {
			System.out.print("ID: " + c.getId() + ", ");
			System.out.print("Nome: " + c.getNome() + ", ");
			System.out.print("Ativo: " + c.isStatus());
			System.out.println();
		});
	}

}