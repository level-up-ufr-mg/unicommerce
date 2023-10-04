import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.unicommerce.dto.DadosCadastraPedido;
import br.com.alura.unicommerce.dto.DadosCadastraProduto;
import br.com.alura.unicommerce.dto.DadosDeProduto;
import br.com.alura.unicommerce.modelo.Categoria;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
public class PedidoControllerTest {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosCadastraPedido> dadosNovoPedidoJson;
	
	
	
	@Test
	@DisplayName("Cadastra novo pedido")
	@WithMockUser
	void cenario_cadastrar_novo_pedido() throws Exception {
		
		List<DadosDeProduto> produtos = new ArrayList<>();
		
		produtos.add(new DadosDeProduto(1L, 2));
		produtos.add(new DadosDeProduto(2L, 1));

		DadosCadastraPedido dadosNovoPedido = new DadosCadastraPedido (1L, new BigDecimal("1000"), produtos); 
		
		var dados = dadosNovoPedidoJson.write(dadosNovoPedido);
		
		var response = mvc.perform(post("/api/pedido")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dados.getJson()))
				.andReturn().getResponse();
		
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
				//assertEquals(201, response.getStatus());
				
		
	}
	
	@Test
	@DisplayName("Detalha pedido")
	@WithMockUser
	void cenario_detalha_pedido(){
		
	}

}
