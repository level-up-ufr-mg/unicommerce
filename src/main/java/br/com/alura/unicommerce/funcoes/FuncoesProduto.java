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
		
		/* CadastraProduto(em); */
		/* BuscaPorId(em); */
		listaIndisponiveis(em);
		buscaPorNomeDaCategoria(em);
	}

	private static void buscaPorNomeDaCategoria(EntityManager em) {
		ProdutoDao produtoDao = new ProdutoDao(em);		
		
		List<Produto> indisponiveis = produtoDao.buscaPorNomeDaCategoria("Informática");
		indisponiveis.forEach(p2 -> System.out.println(p2.getQuantidade_estoque()));
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
		Produto cadeira = new Produto("Mesa gamer", new BigDecimal("1100.00"), "Movel", 0, ATIVA);
				
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		em.getTransaction().begin();
		categoriaDao.cadastra(ATIVA);
		produtoDao.cadastrar(cadeira);
		em.getTransaction().commit();
		em.close();
	}

	private static void listaIndisponiveis(EntityManager em) {
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		List<Produto> indisponiveis = produtoDao.listaIndisponiveis(0);
		indisponiveis.forEach(p2 -> System.out.println(p2.getQuantidade_estoque()));
	}
}