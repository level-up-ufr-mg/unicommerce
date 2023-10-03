package br.com.alura.unicommerce.test.categoria.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.repository.CategoriaRepository;
import br.com.alura.util.service.CategoriaService;

@ExtendWith(SpringExtension.class)
public class CategoriaControllerTest {

	@InjectMocks
	CategoriaService service;

	@Mock
	CategoriaRepository repository;

	

	private long existingId = 1L;
	private long noExistingId = 9999L;

	@Test
	@DisplayName("Buscar Categoria por Id que exita")
	void buscaCategoria() throws Exception {
		var obj = service.buscaPorId(existingId);
		assertNotNull(obj);
	}

	@Test
	@DisplayName("Buscar Categoria por Id que nao exite no banco de dados")
	void buscaCategoriaInexistente() throws Exception {
		var obj = service.buscaPorId(noExistingId);
		assertNotNull(obj);
	}

	@Test
	@DisplayName("quando cadastra categoria null no banco retorna um Exception.")
	void cadastraCategoriaInvalida() {
		  Categoria categoria = null;
			assertThrows(Exception.class, () -> service.cadastra(categoria));
	}

	@Test
	@DisplayName("cadastra categoria já existente")
	void cadastraCategoriaExistente() {
	    Categoria categoria = new Categoria("categoria");

	    // Tenta cadastrar a categoria duas vezes
	    try {
	        service.cadastra(categoria); // Primeiro cadastro
	        service.cadastra(categoria); // Segundo cadastro
	    } catch (Exception e) {
	        // Lidar com exceção, se necessário
	    }

	    // Verifique se o segundo cadastro não adicionou uma nova entrada no banco de dados
	    long count = repository.count();
	    assertEquals(1, count);
	}




}
