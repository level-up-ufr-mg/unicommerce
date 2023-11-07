package br.com.alura.unicommerce.DTO;

import br.com.alura.unicommerce.Domain.Cliente.Cliente;
import br.com.alura.unicommerce.Domain.Endereco.Endereco;
import br.com.alura.unicommerce.Domain.Usuario.Usuario;

public record DadosDetalhamentoCliente(Long id, String nome, String cpf, String telefone, Endereco endereco,
		Usuario usuario) {
	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEndereco(),
				cliente.getUsuario());
	}
}