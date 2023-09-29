package br.com.alura.unicommerce.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.alura.util.domain.categoria.Categoria;
import br.com.alura.util.repository.CategoriaRepository;

public class CadastroCategoriaTest {


	 
		@Mock
	    private CategoriaRepository categoriaRepository;


	
	
	@Test
	public void CadastraCategoiaValida() {
	    String nomevalido = "Valido";
	    assertThrows(IllegalArgumentException.class, () -> new Categoria(nomevalido));
	}
	
	@Test
	public void deveFalharACriacaoDeCategoriaComNomeNulo() {
	    String nomeNulo = null;
	    assertThrows(IllegalArgumentException.class, () -> new Categoria(nomeNulo));
	}

	@Test
	public void deveFalharACriacaoDeCategoriaComNomeVazio() {
	    String nomeVazio = "";
	    assertThrows(IllegalArgumentException.class, () -> new Categoria(nomeVazio));
	}
	
	
	
//	    @Test
//	    public void deveFalharAoCriarCategoriaComNomeExistente() {
//	        String nomeExistente = "xpto";
//
//	         
//	        when(categoriaRepository.existsByNome(nomeExistente)).thenReturn(true);
//
//	         
//	        assertThrows(IllegalArgumentException.class, () -> new  Categoria(nomeExistente));
//	    }
	
	

}
