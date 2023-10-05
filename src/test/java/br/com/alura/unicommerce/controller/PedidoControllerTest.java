package br.com.alura.unicommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.unicommerce.dto.DadosDePedido;
import br.com.alura.unicommerce.dto.DadosDeProduto;
import br.com.alura.unicommerce.dto.DadosListagemCategoria;
import br.com.alura.unicommerce.dto.DadosNovaCategoria;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PedidoControllerTest {

	private MockMvc mvc;

	private JacksonTester<DadosDePedido> dadosDePedidoJson;

	@Test
	@DisplayName("Cadastrar novo pedido")
	@WithMockUser
	void cenario_cadastro_novo_pedido() throws Exception {

		DadosDePedido dadosNovoPedido = criaNovoPedido();

		var dados = dadosDePedidoJson.write(dadosNovoPedido).getJson();

		var response = mvc.perform(post("/api/pedidos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dados))
				.andReturn().getResponse();
		
		assertEquals(201, response.getStatus());
	}
	
	@Test
	@DisplayName("Buscar pedido por id")
	@WithMockUser
	void buscaPedidoPorId() throws Exception {
		
		DadosDePedido dadosNovoPedido = criaNovoPedido();

		var dados = dadosDePedidoJson.write(dadosNovoPedido).getJson();
		
		var response = mvc.perform(get("/api/pedidos/2"))
				.andReturn()
				.getResponse();
		
		response.getContentAsString();
		
		DadosDePedido dadosPedido = dadosDePedidoJson.parseObject(response.getContentAsString());
		
		assertEquals(response.getStatus(), 200);
	}


	private DadosDePedido criaNovoPedido() {
		List<DadosDeProduto> produtos = new ArrayList<>();
		produtos.add(new DadosDeProduto(1l, 2));
		produtos.add(new DadosDeProduto(2l, 3));
		DadosDePedido dadosNovoPedido = new DadosDePedido(1l, new BigDecimal("1000"), produtos);

		return dadosNovoPedido;
	}
}
