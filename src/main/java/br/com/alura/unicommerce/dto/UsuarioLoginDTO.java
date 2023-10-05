package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Usuario;

public record UsuarioLoginDTO (Long id, String login) {

	public UsuarioLoginDTO(Usuario dados) {
		this(dados.getId() ,dados.getLogin());
	}
	
}
