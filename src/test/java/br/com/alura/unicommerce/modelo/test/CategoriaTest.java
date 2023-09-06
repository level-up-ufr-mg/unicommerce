package br.com.alura.unicommerce;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.modelo.Categoria;

class CategoriaDaoTest {
	
	Categoria categoriaNomeValido = new Categoria("Nome Válido", true);
	
	
	Categoria categoriaNomeVazio = new Categoria("", true);
	Categoria categoriaNomeNull = new Categoria(null, true);
	Categoria categoriaNomeEsperado = new Categoria("Brinquedos", true);
	
	//CategoriaDao categoriaDao = new CategoriaDao();
	
	@Test
	public void testaNomeValidoParaCategoria() {
		
		String nomeEsperado = categoriaNomeValido.getNome();
		System.out.println(nomeEsperado);
		Assertions.assertEquals(categoriaNomeValido.getNome(), nomeEsperado);

	}
	
	@Test
	public void testaVazioParaNomeDaCategoria() {
		
		String nomeEsperado = categoriaNomeVazio.getNome();
		assertTrue(nomeEsperado.isEmpty());

	}
	
	@Test
	public void testaNullParaNomeDaCategoria() {
		
		try {
			categoriaNomeNull.getNome();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		Assertions.assertEquals(null, categoriaNomeNull.getNome());
	}

}
