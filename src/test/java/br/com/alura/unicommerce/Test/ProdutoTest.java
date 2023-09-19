package br.com.alura.unicommerce.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import br.com.alura.util.Categoria.Categoria;
import br.com.alura.util.Produto.Produto;
import br.com.unicommerce.Service.PrecoInvalidoException;

class ProdutoTest {

	
	
//	
//	@Test
//	void PrecoValido() {
//		Categoria categoria = new Categoria(null,"saude","ativado");
//	Produto produtoValido = new Produto(null,"Vacina","Covid19",10L, new BigDecimal("250.00"), categoria);	
//	assertThrows(PrecoInvalidoException.class, () ->  produtoValido.setPrecoUntario(new BigDecimal("-10.00")));
//	assertEquals( new BigDecimal("250.00"),produtoValido.getPreco());
//	}
//
//	
//	
//	@Test
//	void PrecoInvalido() {
//	    Categoria categoria = new Categoria(null, "Informatica", "ativado");
//	    Produto produtoValido = new Produto(null,"MacBook", "slim 17 polegadas", 5L, new BigDecimal("10.00"), categoria);    
//	    assertThrows(PrecoInvalidoException.class, () -> produtoValido.setPreco(new BigDecimal("-10.00")));
//	}

}
