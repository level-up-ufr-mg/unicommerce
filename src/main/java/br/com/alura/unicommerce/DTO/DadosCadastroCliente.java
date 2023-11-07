package br.com.alura.unicommerce.DTO;

import org.hibernate.validator.constraints.br.CPF;

import br.com.alura.unicommerce.Domain.Usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroCliente(
		@NotBlank @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres!") String nome,
		@NotBlank @CPF String cpf, @NotBlank String telefone, @Valid DadosEndereco endereco, Usuario usuario) {
}