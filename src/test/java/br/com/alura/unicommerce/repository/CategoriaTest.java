package br.com.alura.unicommerce.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.unicommerce.modelo.Categoria;

public class CategoriaTest {

	@Autowired
	private CategoriaRepository repository;
	
	
	@Test
	@DisplayName("Destiva categoria")
	void cadastrarNovaCategoria () {
		
		var categoria = cadastroCategoria("Materiais de Construção");
		assertNotNull(categoria);
	}
	
	@Test
	@DisplayName("Destiva categoria")
	void desativaCategoria () {
		
		var categoria = cadastroCategoria("Perfumaria");
		desativarCategoria(categoria);
		
		assertNotNull(categoria);
	}

	private Categoria desativarCategoria(Categoria categoria) {
		categoria.excluir();
		return repository.save(categoria);
		
	}

	private Categoria cadastroCategoria(String nome) {
		return repository.save(new Categoria(nome));
	}
}
