package br.com.alura.unicommerce.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class CadatroDeProduto {
	public static void main(String[] args) {
		Categoria ATIVA = new Categoria("ATIVA");
		Produto cadeira = new Produto("Cadeira Gammer", new BigDecimal("500.00"), "Movel", 50, ATIVA);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(ATIVA);
		produtoDao.cadastrar(cadeira);
		em.getTransaction().commit();
		em.close();
	}

	/*
	 * public static void cadastrarProduto() { Categoria ATIVA = new
	 * Categoria("ATIVA"); Produto cadeira = new Produto("Cadeira Gammer", new
	 * BigDecimal("500.00"), "Movel", 50, ATIVA);
	 * 
	 * EntityManager em = JPAUtil.getEntityManager(); ProdutoDao produtoDao = new
	 * ProdutoDao(em); CategoriaDao categoriaDao = new CategoriaDao(em);
	 * 
	 * em.getTransaction().begin(); categoriaDao.cadastrar(ATIVA);
	 * produtoDao.cadastrar(cadeira); em.getTransaction().commit(); em.close(); }
	 */

}