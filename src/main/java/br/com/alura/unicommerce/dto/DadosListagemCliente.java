package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Cliente;

public record DadosListagemCliente(
		
		String nome,
		
		String cpf,
		
		String telefone,
		
		String local) { // Local - Cidade/Estado
	
	
	public DadosListagemCliente(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEndereco().getCidade()+"/"+cliente.getEndereco().getEstado());
	}


}
