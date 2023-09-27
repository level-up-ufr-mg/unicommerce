package br.com.alura.unicommerce.dto;

import java.util.Optional;

import br.com.alura.unicommerce.modelo.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDTO(Long id,

		@NotBlank(message = "{nome.obrigatorio}") String nome,

		@NotBlank(message = "cpf.obrigatorio") String cpf,

		String telefone,

		@NotNull(message = "{endereco.obrigatorio}") 
		@Valid EnderecoDTO endereco,

		@Valid UsuarioDTO usuario) {

	
	public ClienteDTO(Optional<Cliente> obj) {
		this(obj.get().getId(), obj.get().getNome(), obj.get().getCpf(), obj.get().getTelefone(), new EnderecoDTO(obj.get().getEndereco()), new UsuarioDTO(obj.get().getUsuario()));
	}

	public ClienteDTO(Cliente obj) {
		this(obj.getId(), obj.getNome(), obj.getCpf(), obj.getTelefone(), new EnderecoDTO(obj.getEndereco()), new UsuarioDTO(obj.getUsuario()));

	}

		
}
