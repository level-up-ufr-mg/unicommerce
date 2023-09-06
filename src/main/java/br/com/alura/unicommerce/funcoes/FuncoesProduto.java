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
<<<<<<< HEAD
		
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
=======

		/*
		 * cadastraProduto(em); buscaPorId(em); listaTodos(em);
		 */
		listaIndisponiveis(em, );

	}

	private static void buscaPorId(EntityManager em) {
		ProdutoDao produtoDaoBuscaPorId = new ProdutoDao(em);
>>>>>>> ab5d880 (Adicionando funções)

	private static void BuscaPorId(EntityManager em) {
		ProdutoDao produtoBuscaPorId = new ProdutoDao(em);

		Produto p = produtoBuscaPorId.buscaPorId(2l);
		System.out.println(p.getId());

		List<Produto> listaTodos = produtoBuscaPorId.listaTodos();
		listaTodos.forEach(p2 -> System.out.println(p.getNome()));
	}

<<<<<<< HEAD
	private static void CadastraProduto(EntityManager em) {		
		Categoria ATIVA = new Categoria("Informática", true);
		Produto cadeira = new Produto("Mesa gamer", new BigDecimal("1100.00"), "Movel", 0, ATIVA);
				
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		em.getTransaction().begin();
		categoriaDao.cadastra(ATIVA);
		produtoDao.cadastrar(cadeira);
=======
	private static void cadastraProduto(EntityManager em) {
		Categoria categoria = new Categoria("Roupas", true);
		Produto produto = new Produto(null, "Camiseta Branca", new BigDecimal("20.00"), "Vestuário", 100, categoria);

		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
>>>>>>> ab5d880 (Adicionando funções)
		em.getTransaction().commit();
		em.close();
	}

<<<<<<< HEAD
	private static void listaIndisponiveis(EntityManager em) {
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		List<Produto> indisponiveis = produtoDao.listaIndisponiveis(0);
		indisponiveis.forEach(p2 -> System.out.println(p2.getQuantidade_estoque()));
	}
=======
	private static void listaTodos(EntityManager em) {
		ProdutoDao produtoDaoListaTodos = new ProdutoDao(em);

		List<Produto> listaTodos = produtoDaoListaTodos.listaTodos();
		listaTodos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void listaIndisponiveis(EntityManager em, Categoria categoria) {
	    String jpql = "SELECT p FROM Produto p WHERE p.categoria = :categoria AND p.quantidadeEmEstoque = 0";
	    List<Produto> produtosIndisponiveis = em.createQuery(jpql, Produto.class)
	            .setParameter("categoria", categoria)
	            .getResultList();

	    // Agora você pode fazer o que quiser com a lista de produtos indisponíveis, por exemplo, imprimi-los.
	    for (Produto produto : produtosIndisponiveis) {
	        System.out.println("Produto Indisponível: " + produto.getNome());
	    }
	}

	
>>>>>>> ab5d880 (Adicionando funções)
}