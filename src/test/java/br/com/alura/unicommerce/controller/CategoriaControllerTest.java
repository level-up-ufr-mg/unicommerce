package br.com.alura.unicommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

import br.com.alura.unicommerce.dto.DadosListagemCategoria;
import br.com.alura.unicommerce.dto.DadosNovaCategoria;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class CategoriaControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosListagemCategoria> dadosCategoriaJson;
	
	@Autowired
	private JacksonTester<DadosNovaCategoria> dadosNovaCategoriaJson;
	
	@Test
	@DisplayName("Valida a consulta de uma categoria por id")
	@WithMockUser
	void cria_categoria() throws Exception {
		
		System.out.println(dadosNovaCategoriaJson.write(new DadosNovaCategoria("Móveis")).getJson());
		
		var response = mvc.perform(get("/api/categorias/2"))
				.andReturn()
				.getResponse();
		
		System.out.println(response.getContentAsString());
		
		DadosListagemCategoria dadosCategoria = dadosCategoriaJson.parseObject(response.getContentAsString());
		
		System.out.println(dadosCategoria);
		 
		assertEquals(response.getStatus(), 200);

	}
	
	@Test
	@DisplayName("Cadastro nova categoria")
	@WithMockUser
	void cadastroNovaCategoria() throws Exception {

			var dados = dadosNovaCategoriaJson
							.write(new DadosNovaCategoria("Supremento")).getJson();
			
			System.out.println(dados);
			
			var response = mvc.perform(post("/api/categorias")
								.contentType(MediaType.APPLICATION_JSON)
								.content(dados))
								.andReturn().getResponse();
			
			System.out.println(response.getContentAsString());
			
			assertEquals(201, response.getStatus());
	}
	

}