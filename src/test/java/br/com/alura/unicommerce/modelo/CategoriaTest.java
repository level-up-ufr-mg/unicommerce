package br.com.alura.unicommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CategoriaTest {

	Categoria novaCategoria = null;

	@Test
	void deveCriarCategoriaComNomeValido() {
		Categoria novaCategoria = new Categoria("Celular");

		assertEquals("Celular", novaCategoria.getNome());
	}

	@Test
	void deveValidarCategoriaComNomeNull() {

		Categoria novaCategoria = null;

		try {
			novaCategoria = new Categoria();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assertEquals(null, novaCategoria);

	}

	@Test
	void deveValidarCategoriaComNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> novaCategoria = new
				 Categoria(""));
	}
	
	@Test
	void deveValidarMudarONomeDaCategoriaParaNomeVazio() {
		
		Categoria novaCategoria = new Categoria("Celular");

		novaCategoria.setNome("");
		
		assertEquals("Celular", novaCategoria.getNome());
	}


}
