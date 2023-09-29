package br.com.alura.util.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDto(
		@NotBlank
		String login,
		
		@NotBlank
		String senha) {

}
