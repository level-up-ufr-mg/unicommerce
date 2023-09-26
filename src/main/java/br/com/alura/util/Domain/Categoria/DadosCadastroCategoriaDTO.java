package br.com.alura.util.Domain.Categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoriaDTO( 
		@NotBlank
		String nome) {

}
