package br.com.alura.util.Domain.Cliente;

public record ListaDadosClieteDTO(String nome, Long cpf, Long telefone, String local) {

	
	public ListaDadosClieteDTO(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf(), cliente.getTelefone(), 
				cliente.getEndereco().getLocal());
	}
}