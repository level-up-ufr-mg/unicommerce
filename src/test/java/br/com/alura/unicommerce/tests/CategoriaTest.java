package br.com.alura.unicommerce.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaTest {

	@Test
	public void nomeValido() {
		
		Categoria categoria = new Categoria("Celular");
		
		assertEquals("Celular" , categoria.getNome() );
	} 
	
	
	@Test
	public void nomeVazio() {
		
		Categoria categoria = null;
		
		try{
			categoria = new Categoria(null);
			
		}catch (Exception e) {
			System.out.println(e);
			
	    }
		assertEquals(null, categoria);
		
    } 
	
	@Test
	public void nomeNulo() {
		
		Categoria categoria = null;
		
		try{
			categoria = new Categoria("");
			
		}catch (Exception e) {
			System.out.println(e);
			
	    }
		assertEquals(null, categoria);
		
    } 
	
	
	
}
