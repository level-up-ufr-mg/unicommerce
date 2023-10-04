import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.alura.unicommerce.dto.DadosCadastraProduto;
import br.com.alura.unicommerce.dto.DadosDetalhamentoCategoria;
import br.com.alura.unicommerce.modelo.Categoria;
import br.com.alura.unicommerce.modelo.Pedido;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class ProdutoControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private Pedido pedido;
	
	@Autowired
	private JacksonTester<DadosCadastraProduto> dadosCadastraProdutoJSON;
	
	@Test
	@DisplayName("Deveria retornar codigo http 400 informação estão inválidas")
	@WithMockUser //simula o usuario logado
	void cadastra_cenario1() throws Exception {
		var response = mvc.perform(post("/api/produtos")).
				andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
	
	@Test
	@DisplayName("Deveria retornar codigo http 200 informação estão válidas")
	@WithMockUser //simula o usuario logado
	void cadastra_cenario2() throws Exception {
		
		DadosDetalhamentoCategoria dados = new DadosDetalhamentoCategoria("Eletrônico", true);
		
		Categoria categoria = new Categoria("Eletrônicos", true);
		
		//when()
  
		var response = mvc.perform(
				post("/api/produtos")
					.contentType(MediaType.APPLICATION_JSON)
					.content(dadosCadastraProdutoJSON.write(
						new DadosCadastraProduto("Carregador", new BigDecimal("140"), "Carregador Turbo", 4, categoria)
					).getJson())
				).
				andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
		
	}

}
