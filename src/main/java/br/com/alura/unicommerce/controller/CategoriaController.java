package br.com.alura.unicommerce.controller;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.util.JPAUtil;

public class CategoriaController {

	public static void main(String[] args) {

		cadastrarCategoria();
	}

	private static void cadastrarCategoria() {
		EntityManager em = JPAUtil.getEntityManager();

		Categoria informatica = new Categoria("INFORMÁTICA", true);
		Categoria movel = new Categoria("MÓVEIS", true);
		Categoria livro = new Categoria("LIVROS", true);
		Categoria celular = new Categoria("CELULARES", true);
		Categoria automotiva = new Categoria("AUTOMOTIVA", true);

		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(informatica);
		categoriaDao.cadastrar(movel);
		categoriaDao.cadastrar(livro);
		categoriaDao.cadastrar(celular);
		categoriaDao.cadastrar(automotiva);

		em.getTransaction().commit();
		em.close();
	}
}
