package br.com.alura.unicommerce.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ProdutoTest {

	@Test
	public void deveValidarOPrecoAcimaDeZero() {

		Categoria categoria = new Categoria("Saúde", true);
		Produto produtoPreco = new Produto("Vacina", "vacinação 2023 contra a influenza (gripe)", new BigDecimal("250"), 1, categoria );

		assertEquals(new BigDecimal("250") , produtoPreco.getPreco());
	}


	@Test
	public void deveValidarOPrecoIgualOuMenorQueZero() {


		Categoria Informatica = new Categoria("Informática", true);
		
		Produto produtoPreco = new Produto("Macbook Pro", "Apple Macbook Pro ( Chip M2, 8gb, 256gb, 13 Polegadas ) 2022 Cor Cinza-espacial", new BigDecimal("0.0"), 1, Informatica );
		
		assertThrows(IllegalArgumentException.class, () ->  produtoPreco.setPreco(BigDecimal.ZERO));
		
		assertThrows(IllegalArgumentException.class, () -> produtoPreco.setPreco(new BigDecimal("-5.0")));
	}
		
}
