package br.com.alura.unicommerce.DTO;

import br.com.alura.unicommerce.Domain.Cliente.Cliente;

public record DadosListagemCliente(String nome, String cpf, String telefone) {

	public DadosListagemCliente(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
	}

}