//package br.com.alura.unicommerce.modelo;
//
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.math.BigDecimal;
//
//import org.junit.jupiter.api.Test;
//
//import br.com.alura.unicommerce.Domain.Produto;
//import br.com.alura.unicommerce.Domain.Categoria.Categoria;
//import br.com.alura.unicommerce.dao.CategoriaDao;
//import br.com.alura.unicommerce.dao.ProdutoDao;
//import br.com.alura.unicommerce.util.JPAUtil;
//import jakarta.persistence.EntityManager;
//
//class ProdutoTest {
//	EntityManager em = JPAUtil.getEntityManager();
//	ProdutoDao produtoDao = new ProdutoDao(em);
//	CategoriaDao categoriaDao = new CategoriaDao(em);
//
//	@Test
//	void deveRegistrarUmProdutoSemNengumErro() {
//		assertDoesNotThrow(() -> {
//			new Produto("Vacina", new BigDecimal("250.00"), "Injetável", 20, new Categoria("Saude"));
//		});
//	}
//
//	@Test
//	void deveRegistrarUmProdutoComPrecoMenorDoQueZero() {
////		try {
////			novoProduto = new Produto("Vacina", new BigDecimal("-250"), "Injetável", 20, new Categoria("Saude"));
////		} catch (Exception e) {
////			System.out.println(e);
////		}
////		assertEquals(null, novoProduto);
//		
//		assertThrows(IllegalArgumentException.class, () -> {
//			new Produto("Vacina", new BigDecimal("-250"), "", 20, new Categoria("Saude"));
//		});
//	}
//
//	@Test
//	void deveRegistrarUmProdutoComPrecoIgualAZero() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			new Produto("Macbook Pro", new BigDecimal("0"), "Burgues", 10, new Categoria("Informatica"));
//		});
//	}
//	
//	@Test
//	void deveRegistrarUmProdutoComPrecoNulo() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			new Produto("Vacina", null, "Injetável", 20, new Categoria("Saude"));
//		});
//	}
//
//	@Test
//	void deveRegistrarUmProdutoComQuantidadeEmEstoqueNegativa() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			new Produto("Vacina", new BigDecimal("250"), "Injetável", -20, new Categoria("Saude"));
//		});
//	}
//
//	@Test
//	void deveRegistrarUmProdutoComQuantidadeNula() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			new Produto("Vacina", new BigDecimal("-250"), "Injetável", null, new Categoria("Saude"));
//		});
//
//	}
//}
