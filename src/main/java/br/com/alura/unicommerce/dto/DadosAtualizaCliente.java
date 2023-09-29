package br.com.alura.unicommerce.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCliente(
		
		@NotNull
		Long id,
		
		String nome,
		
		
		String cpf, 
		

		String telefone,
		
		
		DadosEndereco endereco) {

	
	
	
	
}
