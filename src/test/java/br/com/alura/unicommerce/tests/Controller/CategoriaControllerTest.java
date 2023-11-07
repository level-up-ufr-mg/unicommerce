package br.com.alura.unicommerce.tests.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.unicommerce.DTO.DadosCadastroCategoria;
import br.com.alura.unicommerce.DTO.DadosNovaCategoria;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class CategoriaControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<DadosCadastroCategoria> dadosCategoriaJson;

	@Autowired
	private JacksonTester<DadosNovaCategoria> dadosNovaCategoriaJson;

	@Test
	@DisplayName("Valida a consulta de uma categoria por id")
	@WithMockUser
	void cria_categoria() throws Exception {

		System.out.println(dadosNovaCategoriaJson.write(new DadosNovaCategoria("Celulares")).getJson());
		var response = mvc.perform(get("/categoria/2")).andReturn().getResponse();
		System.out.println(response.getContentAsString());
		DadosCadastroCategoria dadosCategoria = dadosCategoriaJson.parseObject(response.getContentAsString());
		System.out.println(dadosCategoria);
		Assertions.assertEquals(response.getStatus(), 200);
	}
}