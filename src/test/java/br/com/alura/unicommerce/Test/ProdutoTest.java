package br.com.alura.unicommerce.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.domain.produto.Produto;

class ProdutoTest {

	
	Categoria categoria = new Categoria("Saude");
	
	 
	 
	
	@Test
	void CadastrandoProdutoComPrecoValido() {
		
	Produto produtoValido = new Produto(null, "Vacina","Covid19",10L, new BigDecimal("250.00"), categoria);	
	
	assertThrows(IllegalArgumentException.class, () ->  produtoValido.setPreco(new BigDecimal("-10.00")));
	assertEquals( new BigDecimal("250.00"),produtoValido.getPreco());
	}

	
	
	@Test
	void CadastrandoProdutoCOmPrecoInvalido() {
	    Produto produtoValido = new Produto(null,"MacBook", "slim 17 polegadas", 5L, new BigDecimal("10.00"), categoria);    
	    assertThrows(IllegalArgumentException.class, () -> produtoValido.setPreco(new BigDecimal("-10.00")));
	}

	
	
	
	 
	
}
