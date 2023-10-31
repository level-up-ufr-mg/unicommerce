package br.com.alura.unicommerce.DTO;

import org.hibernate.validator.constraints.br.CPF;

import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastraCliente(
		@NotBlank @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres") String nome,
		@NotBlank @CPF String cpf, @NotBlank String telefone, @NotNull @Valid DadosEndereco endereco) {

	public DadosCadastraCliente(Cliente dados) {
		this(dados.getNome(), dados.getCpf(), dados.getTelefone(), new DadosEndereco(dados.getEndereco()));
	}
}