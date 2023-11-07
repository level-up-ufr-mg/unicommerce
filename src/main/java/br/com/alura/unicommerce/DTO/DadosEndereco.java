package br.com.alura.unicommerce.DTO;

import br.com.alura.unicommerce.Domain.Endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record DadosEndereco(@NotBlank String rua,
		@Positive(message = "Número deve ser um inteiro positivo") String numero, String complemento,
		@NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado) {
	
	public DadosEndereco(Endereco endereco) {
		this(endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado());
	}
}