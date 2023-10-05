package br.com.alura.unicommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.unicommerce.dto.DadosDeProduto;
import br.com.alura.unicommerce.dto.DadosListagemProduto;
import br.com.alura.unicommerce.form.ProdutoForm;
import br.com.alura.unicommerce.modelo.Categoria;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
public class ProdutoIT {
	

	@Autowired
	private MockMvc mvc;
	
	
	@Autowired 
	private JacksonTester<DadosListagemProduto> dadosProdutoJson;
	 
	@Autowired
	private JacksonTester<ProdutoForm> dadosNovaProdutoJson;
	
	@Test
	@DisplayName("Cadastar novo produto")
	@WithMockUser
	void cenario_cadastro_novo_produto() throws Exception {


		var dados = dadosNovaProdutoJson.write(new ProdutoForm("IPhone 15", "IPhone 15 Plus", new BigDecimal("15000"), 100, 1l)).getJson();

		var response = mvc.perform(post("/api/produtos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dados))
				.andReturn().getResponse();
		
		assertEquals(201, response.getStatus());
	}

	private ProdutoForm criarNovoProduto() {
		Categoria categoriaEletronicos = new Categoria("Eletrônicos");
		Categoria categoriaCosmeticos = new Categoria("Cosméticos");
			
		//List<ProdutoDTO> produtos = new ArrayList<>();
		ProdutoForm dadosNovoProduto =  new ProdutoForm("IPhone 15", "IPhone 15 Plus", new BigDecimal("15000"), 100, 1l);
		
		//System.out.println(dadosNovoProduto);
		
		//produtos.add(new ProdutoDTO("Xampus", "Xampus", new BigDecimal("150"), 500, categoriaCosmeticos));
		
		return dadosNovoProduto;
	}

}

/*
 * @NotBlank(message = "nome.obrigatorio") String nome,
 * 
 * @NotNull(message = "{descricao.obrigatorio}") String descricao,
 * 
 * BigDecimal preco,
 * 
 * Integer quantidadeEstoque,
 * 
 * Categoria categoria) {
 */