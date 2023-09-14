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
    	long nmroIdDoCliente = 2;
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		Categoria categoria = categoriaDao.buscaPorId(1l);
		Produto produto = new Produto("Mesa normal", new BigDecimal("1100.00"), "Movel", 0, categoria);

//		listaTodos(em);
//		listaIndisponiveis(em);
		buscaPorId(em, nmroIdDoCliente);
//		cadastra(em, categoria, produto);
	}

	private static void buscaPorId(EntityManager em, long nmroIdDoCliente) {
		ProdutoDao buscaPorId = new ProdutoDao(em);

		String produtosPorId = buscaPorId.buscaPorId(nmroIdDoCliente);
		System.out.print("Produto buscado: " + produtosPorId);
	}

	private static void cadastra(EntityManager em, Categoria categoria, Produto produto) {

		CategoriaDao categoriaDao = new CategoriaDao(em);
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