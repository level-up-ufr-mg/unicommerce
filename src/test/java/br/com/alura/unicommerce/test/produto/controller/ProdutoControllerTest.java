package br.com.alura.unicommerce.test.produto.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.domain.produto.DadosCadastroProdutoDTO;

@JsonTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCadastroProdutoDTO> DadosCadastroProdutoDTOJson;

	
	
 
		@Test
	    @DisplayName("deve cadastrar com sucesso um produto")
	    @WithMockUser
	    @Transactional
	    void cadastraProdutoErro200() throws Exception {
	        // Crie um objeto DadosCadastroProdutoDTO com os dados do produto que você deseja inserir
	        DadosCadastroProdutoDTO produtoDTO = new DadosCadastroProdutoDTO(
	                "Produto de Teste",
	                "Descrição do Produto",
	                10L,
	                new BigDecimal("99.99"),
	                new Categoria("Categoria de Teste")
	        );

	        // Use o JacksonTester para serializar o objeto em JSON
	        String produtoJson = DadosCadastroProdutoDTOJson.write(produtoDTO).getJson();

	        // Envie uma solicitação POST para o endpoint /api/produto com o JSON serializado no corpo da solicitação
	        var response =  mvc.perform(post("/api/produto")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(produtoJson))
	                .andExpect(MockMvcResultMatchers.status().isCreated()); // Verifique se a resposta é HTTP 201 (Created)
	    
	       
		
		
		}



 
		
		
	
	
}
