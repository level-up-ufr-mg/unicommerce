package br.com.alura.unicommerce.record;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public record DadosCadastroEndereco(
		@NotBlank
		String rua, 
		
		@NotNull
		@Positive
		Integer numero, 
		
		String complemento, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		String cidade,
		
		@NotBlank
		String estado) {

}
