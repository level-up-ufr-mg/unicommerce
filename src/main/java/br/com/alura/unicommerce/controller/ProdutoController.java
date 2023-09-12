package br.com.alura.unicommerce.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.unicommerce.dao.CategoriaDao;
import br.com.alura.unicommerce.dao.ProdutoDao;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.util.JPAUtil;

public class ProdutoController {

	public static void main(String[] args) {

		cadastrarProduto();

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);

		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p2.getNome()));

		List<Produto> nome = produtoDao.buscarPorNome("Xiaomi Redmi");
		nome.forEach(pNome -> System.out.println(pNome.getNome()));

		List<Produto> categoria = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		categoria.forEach(pCategoria -> System.out.println(pCategoria.getNome()));

		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		System.out.println("Preco do Produto: " + precoDoProduto);

	}

	private static void cadastrarProduto() {
		EntityManager em = JPAUtil.getEntityManager();

		CategoriaDao categoriaDao = new CategoriaDao(em);

		Categoria informatica = categoriaDao.buscarPorId(1l);

		System.out.println("Categoria: " + informatica);

		Categoria moveis = categoriaDao.buscarPorId(2l);
		Categoria livro = categoriaDao.buscarPorId(3l);
		Categoria celular = categoriaDao.buscarPorId(4l);
		Categoria automotiva = categoriaDao.buscarPorId(5l);

		Produto notebookSamsung = new Produto("Notebook Samsung", "Notebook Samsung", new BigDecimal("3523.00"), 50,
				informatica);

		Produto sofa3Lugares = new Produto("Sofá 3 lugares", "Sofá 3 lugares", new BigDecimal(2500.00), 10, moveis);

		Produto cleanArchitecture = new Produto("Clean Architecture", "Clean Architecture", new BigDecimal(102.90), 20,
				livro);

		Produto sofa6Lugares = new Produto("Mesa de jantar 6 lugares", "Mesa de jantar 6 lugares",
				new BigDecimal(3678.98), 10, moveis);

		Produto iPhone13Pro = new Produto("iPhone 13 Pro", "iPhone 13 Pro", new BigDecimal(9176.00), 100, celular);

		Produto monitorDell27 = new Produto("Monitor Dell 27", "Monitor Dell 27", new BigDecimal(1889.00), 50,
				informatica);

		Produto implementingDomainDrivenDesign = new Produto("Implementing Domain-Driven Design",
				"Implementing Domain-Driven Design", new BigDecimal(144.07), 30, livro);

		Produto jogoDePneus = new Produto("Jogo de pneus", "Jogo de pneus", new BigDecimal(1276.79), 5, automotiva);

		Produto cleanCode = new Produto("Clean Code", "Clean Code", new BigDecimal(95.17), 50, livro);

		Produto galaxyS22Ultra = new Produto("Galaxy S22 Ultra", "Galaxy S22 Ultra", new BigDecimal(8549.10), 200,
				celular);

		Produto macbookPro16 = new Produto("Macbook Pro 16", "Macbook Pro 16", new BigDecimal(31752.00), 50,
				informatica);

		Produto refactoringImprovingDesignExistingCode = new Produto(
				"Refactoring Improving the Design of Existing Code",
				"Refactoring Improving the Design of Existing Code", new BigDecimal(173.90), 10, livro);

		Produto camaQueenSize = new Produto("Cama queen size", "Cama queen size", new BigDecimal(3100.00), 5, moveis);

		Produto centralMultimidia = new Produto("Central multimidia", "Central multimidia", new BigDecimal(711.18), 25,
				automotiva);

		Produto buildingMicroservices = new Produto("Building Microservices", "Building Microservices",
				new BigDecimal(300.28), 15, livro);

		Produto GalaxyTabS8 = new Produto("Galaxy Tab S8", "Galaxy Tab S8", new BigDecimal(5939.10), 50, celular);

		ProdutoDao produtoDao = new ProdutoDao(em);

		em.getTransaction().begin();
		
		produtoDao.cadastrar(notebookSamsung);
		produtoDao.cadastrar(sofa3Lugares);
		produtoDao.cadastrar(cleanArchitecture);
		produtoDao.cadastrar(sofa6Lugares);
		produtoDao.cadastrar(iPhone13Pro);
		produtoDao.cadastrar(monitorDell27);
		produtoDao.cadastrar(implementingDomainDrivenDesign);
		produtoDao.cadastrar(jogoDePneus);
		produtoDao.cadastrar(cleanCode);
		produtoDao.cadastrar(galaxyS22Ultra);
		produtoDao.cadastrar(macbookPro16);
		produtoDao.cadastrar(refactoringImprovingDesignExistingCode);
		produtoDao.cadastrar(camaQueenSize);
		produtoDao.cadastrar(centralMultimidia);
		produtoDao.cadastrar(buildingMicroservices);
		produtoDao.cadastrar(GalaxyTabS8);

		em.getTransaction().commit();
		em.close();
	}

}
