package br.com.alura.unicommerce.record;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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
