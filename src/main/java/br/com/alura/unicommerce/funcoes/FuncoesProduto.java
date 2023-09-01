package br.com.alura.unicommerce.funcoes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class FuncoesProduto {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		BuscaPorId(em);

	}

	private static void BuscaPorId(EntityManager em) {
		ProdutoDao produtoBuscaPorId = new ProdutoDao(em);

		Produto p = produtoBuscaPorId.buscaPorId(2l);
		System.out.println(p.getId());

		List<Produto> listaTodos = produtoBuscaPorId.listaTodos();
		listaTodos.forEach(p2 -> System.out.println(p.getNome()));
	}

	private static void CadastraProduto(EntityManager em) {
		
		Categoria ATIVA = new Categoria("Informática", true);
		Produto cadeira = new Produto("Cadeira Gamer", new BigDecimal("500.00"), "Movel", 50, ATIVA);
		
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		em.getTransaction().begin();
		categoriaDao.cadastra(ATIVA);
		produtoDao.cadastrar(cadeira);
		em.getTransaction().commit();
		em.close();
	}
}