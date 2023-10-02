package br.com.alura.unicommerce.record;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.validation.Valid;

public record DadosCadastroCliente(
		@NotBlank
		String nome,
		
		@NotBlank
		String cpf,
		
		@NotBlank
		String telefone,
		
		@Valid
		DadosCadastroEndereco endereco) {

}
