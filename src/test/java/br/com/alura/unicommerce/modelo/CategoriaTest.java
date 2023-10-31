//package br.com.alura.unicommerce.modelo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import org.junit.jupiter.api.Test;
//
//import br.com.alura.unicommerce.Domain.Categoria.Categoria;
//
//class CategoriaTest {
//	private Categoria novaCategoria;
//
//	@Test
//	void DeveCriarUmaCategoriaComNomeValido() {
//		novaCategoria = new Categoria("Eletrônicos");
//		assertEquals("Eletrônicos", novaCategoria.getNome());
//	}
//
//	@Test
//	void DeveCriarUmaCategoriaComNomeNull() {
//		try {
//			novaCategoria = new Categoria(null);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		assertEquals(null, novaCategoria);
//	}
//
//	@Test
//	void DeveCriarUmaCategoriaComNomeVazio() {
//		assertThrows(IllegalArgumentException.class, () -> {
//			novaCategoria = new Categoria("");
//		});
////		try {
////			novaCategoria = new Categoria(" ");
////		} catch (Exception e) {
////			System.out.println(e);
////		}
////		assertEquals(null, novaCategoria);
//	}
//	
//	@Test
//	void deveValidarMudarONomeDaCategoriaParaNomeVazio(){  //Deve dar errado
//		novaCategoria = new Categoria("Celular");
//		novaCategoria.setNome(null);
//		assertEquals("Celular", novaCategoria.getNome());
//	}
//}