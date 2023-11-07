package br.com.alura.unicommerce.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCategoria(
		@NotBlank @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres") String nome) {
}
