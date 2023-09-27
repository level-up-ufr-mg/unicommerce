package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Usuario;

public record UsuarioDTO (Long id, String login) {

	public UsuarioDTO(Usuario dados) {
		this(dados.getId() ,dados.getLogin());
	}
	
}
