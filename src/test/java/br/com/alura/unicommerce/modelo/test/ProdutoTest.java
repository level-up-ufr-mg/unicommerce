package br.com.alura.unicommerce.modelo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Produto;
import br.com.alura.unicommerce.repository.CategoriaRepository;
import br.com.alura.unicommerce.repository.ProdutoRepository;


@SpringBootTest
class ProdutoTest {

	Produto p = new Produto();
	Categoria categoriaVacina = new Categoria("Saúde", true);
	
	
	//Para o teste cadastrar do endeponint /produto
	
	
	
	

//    @Autowired
//    private ProdutoRepository produtoRepository;
//    
//    @Autowired
//    private MockMvc mockMvc;
//
//
//	@Test
//	@DisplayName("Garante que o endpoint /produto faz o cadastro")
//	void garanteQueOEndpointProdutoCadastraUmProduto() {
//		
//		mockMvc.perform(MockMvcRequestBuilders.post("/produto").
//		
//		Produto vacina = new Produto(1l, "Vacina", "Sarampo", 5000, categoriaVacina, new BigDecimal("75.00"));
//		
//		produtoRepository.save(vacina);
//		
//		System.out.println("Dados do produto: " + vacina.getDescricao());
//		
//		produtoRepository.delete(vacina);
//		
//	}

	
	
	@Test
	void naoPermitePrecoMenorOuIgualAZero() {

		Exception ex = null;

		try {
			ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//				p.getPreco();
//				System.out.println(p.getPreco());
				p.setPreco(BigDecimal.ZERO);

				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					p.setPreco(new BigDecimal("-1.0"));
				});
			});
		} catch (Exception e) {

		}
		System.out.println(ex.getMessage());

	}
	
    @Test
    void testaSeOPrecoDoProdutoVacinaEhValido() {
        Produto vacina = new Produto(1l, "Vacina", "BCG", 2000, categoriaVacina, new BigDecimal("250.00"));

        //asserções para verificar as propriedades do produto
        assertEquals(1l, vacina.getId());
        assertEquals("Vacina", vacina.getNome());
        assertEquals("BCG", vacina.getDescricao());
        assertEquals(2000, vacina.getQuantidadeEstoque());
        assertEquals(categoriaVacina, vacina.getCategoria());
        assertEquals(new BigDecimal("250.00"), vacina.getPreco());

        System.out.println("Produto: " + vacina.toString());
    }


	@Test
	void testaSeOPrecoDoProdutoMackbookNaoEhValido() {
		Produto mackbook = new Produto();
		Exception ex = null;

		try {
			ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
				mackbook.setId(3l);
				mackbook.setNome("Vacina");
				mackbook.setDescricao("BCG");
				mackbook.setQuantidadeEstoque(2000);
				mackbook.setCategoria(categoriaVacina);
				mackbook.setPreco(new BigDecimal("0.00"));
			});

		} catch (Exception e) {

		}

		System.out.println(ex.getMessage());
	}

}

//@Test
//void testaSeOPrecoDoProdutoVacinaEhValido() {
//	Produto vacina = new Produto();
//	Exception ex = null;
//
//	try {
//		ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//			vacina.setId(1l);
//			vacina.setNome("Vacina");
//			vacina.setDescricao("BCG");
//			vacina.setQuantidadeEstoque(2000);
//			vacina.setCategoria(categoriaVacina);
//			vacina.setPreco(new BigDecimal("250.00"));
//		});
//
//	} catch (Exception e) {
//
//	}
//
//	System.out.println(ex.getMessage());
//}

//Assertions.assertEquals("Vacina", vacina.getNome());
//Assertions.assertEquals("BCG", vacina.getDescricao());
//Assertions.assertEquals(2000, vacina.getQuantidadeEstoque());
//Assertions.assertEquals(categoriaVacina, vacina.getCategoria());
//Assertions.assertEquals("250.00", vacina.getPreco());
