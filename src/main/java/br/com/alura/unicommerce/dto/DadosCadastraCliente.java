package br.com.alura.unicommerce.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastraCliente(
		
		@NotBlank
		@Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres")
		String nome,
		
		@NotBlank
		@CPF
		String cpf, 
		
		@NotBlank
		String telefone,
		
		@Valid
		DadosEndereco endereco
		
		) {

}
