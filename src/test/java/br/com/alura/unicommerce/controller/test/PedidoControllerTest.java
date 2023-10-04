package br.com.alura.unicommerce.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.unicommerce.record.DadosCadastroPedido;
import br.com.alura.unicommerce.record.DadosDeProduto;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class PedidoControllerTest {

	@Autowired
	private MockMvc mvc;
	
	private JacksonTester<DadosCadastroPedido> dadosNovoPedidoJson;
	
	@Test
	@DisplayName("Cadastra novo pedido")
	@WithMockUser
	void cenario_cadastrar_novo_pedido() throws Exception {
		
		List<DadosDeProduto> produtos = new ArrayList<>();
		
		produtos.add(new DadosDeProduto(1l, 2));
		produtos.add(new DadosDeProduto(2L, 3));
		
		DadosCadastroPedido dadosNovoPedido = new DadosCadastroPedido (1L, produtos);
		
		var dados = dadosNovoPedidoJson.write(dadosNovoPedido);
		
		var response = mvc.perform(post("/pedido")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dados.getJson()))
				.andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		Assertions.assertEquals(201, response.getStatus());
		
	}

	@Test
	@DisplayName("Busca novo pedido")
	void cenario_busca_novo_pedido() {
		
	}
	

	

}
