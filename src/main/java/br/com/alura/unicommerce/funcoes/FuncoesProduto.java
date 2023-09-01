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
		
		Categoria ATIVA = new Categoria("Informática", true);
		Produto cadeira = new Produto(null,"Cadeira Gammer", 
				new BigDecimal("500.00"), "Movel", 50, ATIVA);
		
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		CadastraProduto(em, categoriaDao, produtoDao, ATIVA, cadeira);
		/* BuscaPorId(); */

	}

	private static void BuscaPorId() {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDaoBuscaPorId = new ProdutoDao(em);

		Produto p = produtoDaoBuscaPorId.buscaPorId(1l);
		System.out.println(p.getId());

		List<Produto> listaTodos = produtoDaoBuscaPorId.listaTodos();
		listaTodos.forEach(p2 -> System.out.println(p.getNome()));
	}

	private static void CadastraProduto(EntityManager em, CategoriaDao categoriaDao, 
			ProdutoDao produtoDao, Categoria ATIVA, Produto cadeira) {
		em.getTransaction().begin();
		categoriaDao.cadastrar(ATIVA);
		produtoDao.cadastrar(cadeira);
		em.getTransaction().commit();
		em.close();
	}

}