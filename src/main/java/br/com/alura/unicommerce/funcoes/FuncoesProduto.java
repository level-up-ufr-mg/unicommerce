package br.com.alura.unicommerce.funcoes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.CategoriaId;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;
import javassist.expr.NewArray;

public class FuncoesProduto {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		long nmroIdDoCliente = 2;

//		listaTodos(em);
//		listaIndisponiveis(em);
//		buscaPorId(em, nmroIdDoCliente);
//		cadastra(em);
//		buscarPorParametrosComCriteria(em);
		
		em.find(Categoria.class, new CategoriaId("Moda", "xpto"));
		
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
		Categoria categoria = categoriaDao.buscaPorId(3l);
		Produto produto = new Produto("Vestido de Seda", new BigDecimal("1300.00"), "Vestido", 10, categoria);

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastra(categoria);
		produtoDao.cadastra(produto);
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