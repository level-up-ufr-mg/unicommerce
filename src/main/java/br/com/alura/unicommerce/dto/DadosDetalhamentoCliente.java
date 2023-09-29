package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Cliente;
import br.com.alura.unicommerce.modelo.Endereco;
import br.com.alura.unicommerce.modelo.Usuario;

public record DadosDetalhamentoCliente(
		
		Long id, 
		
		String nome,
	
		String cpf, 
		
		String telefone,
	
		Endereco endereco,
		
		Usuario usuario) {
	
	public DadosDetalhamentoCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), cliente.getEndereco(), cliente.getUsuario());
	}


}
