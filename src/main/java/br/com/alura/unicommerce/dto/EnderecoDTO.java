package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EnderecoDTO(
		@NotBlank
		String rua,
		
		@NotNull
		@Positive
		String numero, 
		
		String complemento, 
		
		@NotBlank
		String bairro, 
			
		@NotBlank
		String cidade,
		
		@NotBlank
		String estado) {

	public EnderecoDTO(Endereco dados) {
		this(dados.getRua(), dados.getNumero(), dados.getComplemento(), dados.getBairro(), dados.getCidade(), dados.getEstado());
	}
;
}

