package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.service.validation.UserInsertValid;

@UserInsertValid
public class UsuarioInsertDTO extends UsuarioDTO {
	private static final long serialVersionUID = 1L;

	private String senha;

	UsuarioInsertDTO() {
		super();
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}