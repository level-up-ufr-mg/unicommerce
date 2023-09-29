package br.com.alura.unicommerce.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;

public class ProdutoTest {

	@Test
	public void precoAcimaDeZero() {
		
		Categoria categoria = new Categoria("Saúde", true);
		Produto produtoPreco = new Produto("Vacina" , new BigDecimal("250"), categoria );
		
		assertEquals(new BigDecimal("250") , produtoPreco.getPreco());
	}
	
	
	@Test
	public void precoIgualOuMenorQueZero() {

		Produto produtoPreco = new Produto();
		Exception ex = null;
		
		try {
			ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
					produtoPreco.setPreco(BigDecimal.ZERO);
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					produtoPreco.setPreco(new BigDecimal("-1.0"));
				});
			});
		}catch (Exception e) {
			System.out.println(ex.getMessage());
		}
	}

	
}
