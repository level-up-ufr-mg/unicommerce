package br.com.alura.util.domain.categoria;

import jakarta.validation.constraints.NotNull;

public record AtualizarDadosCategoriaDTO(
		@NotNull
		Long id,
		String nome,
		Boolean status) {

	public boolean ativo() {
		// TODO Auto-generated method stub
		return false;
	}

}
