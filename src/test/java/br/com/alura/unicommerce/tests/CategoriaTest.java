//package br.com.alura.unicommerce.tests;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//
//import br.com.alura.unicommerce.Domain.Categoria.Categoria;
//
//public class CategoriaTest {
//	@Test
//	public void deveCriarCategoriaComNomeValido() {
//
//		Categoria categoria = new Categoria("Celular");
//		assertEquals("Celular", categoria.getNome());
//	}
//
//	@Test
//	public void deveFalharACriacaoDeCategoriaComNomeVazio() {
//
//		Categoria categoria = null;
//
//		try {
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		assertEquals(null, categoria);
//	}
//
//	@Test
//	public void deveFalharACriacaoDeCategoriaComNomeNulo() {
//
//		Categoria categoria = null;
//		try {
//			categoria = new Categoria("");
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		assertEquals(null, categoria);
//	}
//}