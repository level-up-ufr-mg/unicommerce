package br.com.alura.unicommerce.Controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class ControllerProduto {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		long nmroIdDoCliente = 2;

//		listaTodos(em);
//		listaIndisponiveis(em);
//		buscaPorId(em, nmroIdDoCliente);
//		buscarPorParametrosComCriteria(em);
//		cadastra(em);

		// em.find(Categoria.class, new CategoriaId("Moda", "xpto"));

//		ProdutoDao produtoDao = new ProdutoDao(em);
//		List<RelatorioDeVendasPorProdutoVendidoVo> relatorio = produtoDao.relatorioDeVendasPorProdutoVendidoVo();
//		relatorio.forEach(System.out::println);

		CategoriaDao categoriaDao = new CategoriaDao(em);
		String buscardor = categoriaDao.buscaNomePorNome("Saude");
		System.out.println(buscardor);

	}

	private static void buscarPorParametrosComCriteria(EntityManager em) {
		ProdutoDao produtoDao = new ProdutoDao(em);

		produtoDao.buscarPorParametrosComCriteria("Samsung Galaxy S21", null, null);
	}

	private static void buscaPorId(EntityManager em, long nmroIdDoCliente) {
		ProdutoDao buscaPorId = new ProdutoDao(em);

		Produto produtosPorId = buscaPorId.buscaPorId(nmroIdDoCliente);
		System.out.print("Produto buscado: " + produtosPorId);
	}

	private static void cadastra(EntityManager em) {
		CategoriaDao categoriaDao = new CategoriaDao(em);

		Categoria categoria01 = categoriaDao.buscaPorId(1l);
		Produto produto01 = new Produto("Vestido de Seda", new BigDecimal("1300.00"), "Vestido", 10, categoria01);

		Categoria categoria02 = categoriaDao.buscaPorId(2l);
		Produto produto02 = new Produto("Samsung Galaxy S21", new BigDecimal("999.99"), "Smartphone", 10, categoria02);

		Categoria categoria03 = categoriaDao.buscaPorId(3l);
		Produto produto03 = new Produto("Camiseta Polo", new BigDecimal("29.99"), "Vestuário", 50, categoria03);

		Categoria categoria04 = categoriaDao.buscaPorId(4l);
		Produto produto04 = new Produto("Tênis de Corrida", new BigDecimal("89.99"), "Calçados", 20, categoria04);

		Categoria categoria05 = categoriaDao.buscaPorId(5l);
		Produto produto05 = new Produto("Camiseta Polo", new BigDecimal("49.99"), "Roupas", 30, categoria05);

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		produtoDao.cadastra(produto01);
		produtoDao.cadastra(produto02);
		produtoDao.cadastra(produto03);
		produtoDao.cadastra(produto04);
		produtoDao.cadastra(produto05);
		em.getTransaction().commit();
		em.close();
	}

	private static void listaTodos(EntityManager em) {
		ProdutoDao produtoDaoListaTodos = new ProdutoDao(em);

		List<Produto> listaTodos = produtoDaoListaTodos.listaTodos();
		listaTodos.forEach(p -> {
			System.out.print("ID: " + p.getId() + ", ");
			System.out.print("Nome: " + p.getNome() + ", ");
			System.out.print("Preço: " + p.getPreco() + ", ");
			System.out.print("Descrição: " + p.getDescricao() + ", ");
			System.out.print("Quantidade em Estoque: " + p.getQuantidade_estoque());
			System.out.println();
		});
	}

	private static void listaIndisponiveis(EntityManager em) {
		ProdutoDao listaIndisponiveis = new ProdutoDao(em);

		List<Produto> nomesIndisponiveis = listaIndisponiveis.listaIndisponiveis(0);
		nomesIndisponiveis.forEach(p -> {
			System.out.print("ID: " + p.getId() + ", ");
			System.out.print("Nome: " + p.getNome() + ", ");
			System.out.print("Preço: " + p.getPreco() + ", ");
			System.out.print("Descrição: " + p.getDescricao() + ", ");
			System.out.print("Quantidade em Estoque: " + p.getQuantidade_estoque());
			System.out.println();
		});
	}

}