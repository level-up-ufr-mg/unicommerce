package br.com.alura.unicommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CategoriaTest {

	Categoria novaCategoria = null;

	@Test
	void deveCriarCategoriaComNomeValido() {
		Categoria novaCategoria = new Categoria("Celular", true);

		assertEquals("Celular", novaCategoria.getNome());
	}

	@Test
	void deveValidarCategoriaComNomeNull() {

		Categoria novaCategoria = null;

		try {
			novaCategoria = new Categoria(null, true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		assertEquals(null, novaCategoria);

	}

	@Test
	void deveValidarCategoriaComNomeVazio() {
		assertThrows(IllegalArgumentException.class, () -> novaCategoria = new
				 Categoria("", true));
	}
	
	@Test
	void deveValidarMudarONomeDaCategoriaParaNomeVazio() {
		
		Categoria novaCategoria = new Categoria("Celular", true);

		novaCategoria.setNome("");
		
		assertEquals("Celular", novaCategoria.getNome());
	}


}
