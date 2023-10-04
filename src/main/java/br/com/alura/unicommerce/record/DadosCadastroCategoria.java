package br.com.alura.unicommerce.record;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Dados que serão enviados no corpo da requisição para a API
public record DadosCadastroCategoria(
		
		@NotBlank 
		@Size(min = 2, max = 50, message = "O nome deve conter no mínimo 2 caracteres.")
		String nome,
		@NotNull
		Boolean status) { 
}
