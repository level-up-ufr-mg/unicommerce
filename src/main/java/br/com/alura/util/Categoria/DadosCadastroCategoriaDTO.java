package br.com.alura.util.Categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoriaDTO( 
		@NotBlank
		String nome) {

}
