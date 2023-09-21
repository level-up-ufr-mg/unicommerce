package br.com.alura.unicommerce.record;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
