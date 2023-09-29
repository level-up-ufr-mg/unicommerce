package br.com.alura.unicommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosEndereco(
		
		@NotBlank
		String rua, 
		
		@Positive(message = "Número deve ser um inteiro positivo")
		Integer numero, 
	
		String complemento, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		String cidade, 
		
		@NotBlank
		String estado) {
}

