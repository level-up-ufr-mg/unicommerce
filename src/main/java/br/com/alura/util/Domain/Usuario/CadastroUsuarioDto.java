package br.com.alura.util.Domain.Usuario;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDto(
		@NotBlank
		String login,
		
		@NotBlank
		String senha) {

}
