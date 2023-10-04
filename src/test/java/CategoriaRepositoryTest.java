import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.unicommerce.repository.CategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository repository;
	
	@Test
	@DisplayName("Deveria devolver null quando a categoria não tiver vendas")
	void getRelatorioVendasPorCategoria() {
	     
		//var categoriaLivre = repository.getRelatorioVendasPorCategoria(null);
		//assertThat(categoriaLivre).isNull();
	}

}
