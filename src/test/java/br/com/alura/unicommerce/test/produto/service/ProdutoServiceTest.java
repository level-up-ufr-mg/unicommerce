package br.com.alura.unicommerce.test.produto.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.domain.categoria.ListaDadosCategoriaDTO;
import br.com.alura.util.domain.produto.DadosCadastroProdutoDTO;
import br.com.alura.util.domain.produto.Produto;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters	
class ProdutoTest {



	Categoria categoria = new Categoria("Saude");

	@Test
	@DisplayName("deve cadastra produto com preco valido")
	void CadastrandoProdutoComPrecoValido() {

		Produto produtoValido = new Produto(null, "Vacina", "Covid19", 10L, new BigDecimal("250.00"), categoria);

		assertThrows(IllegalArgumentException.class, () -> produtoValido.setPreco(new BigDecimal("-10.00")));
		assertEquals(new BigDecimal("250.00"), produtoValido.getPreco());
	}

	@Test
	@DisplayName("nao deve cadastra produto com preco invalido ")
	void CadastrandoProdutoCOmPrecoInvalido() {
		Produto produtoValido = new Produto(null, "MacBook", "slim 17 polegadas", 5L, new BigDecimal("10.00"),
				categoria);
		assertThrows(IllegalArgumentException.class, () -> produtoValido.setPreco(new BigDecimal("-10.00")));
	}



}
