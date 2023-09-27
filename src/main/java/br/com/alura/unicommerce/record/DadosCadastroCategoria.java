package br.com.alura.unicommerce.record;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Dados que serão enviados no corpo da requisição para a API
public record DadosCadastroCategoria(
		
		@NotBlank 
		@Size(min = 2, max = 50, message = "O nome deve conter no mínimo 2 caracteres.")
		String nome,
		@NotNull
		Boolean status) { 
}
