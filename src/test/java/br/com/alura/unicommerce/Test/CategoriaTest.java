package br.com.alura.unicommerce.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.modelo.Categoria;

class CategoriaTest {
 
	@Test
	public void nomeValido() {
		Categoria categoria = new Categoria("Celular");
		assertEquals("Celular", categoria.getNome());
	}

	@Test
	public void nomeVazio() { 
		Categoria categoria = null;
		try {
			categoria = new Categoria(null);
		} catch (Exception e) {
			System.out.print(e);
		}
		assertEquals(null, categoria.getNome());
	}

	
	@Test
	public void nomeNulo() {
		Categoria categoria = null;
		try {
			categoria = new Categoria("");
		} catch (Exception e) {
			System.out.print(e);
		}
		assertEquals(null, categoria.getNome());
	}
	
	
	
	
	
	
	
	
	
	
}
