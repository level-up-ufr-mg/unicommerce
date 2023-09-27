package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Categoria;
import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(Long id, 
		
		@NotBlank(message = "nome.obrigatorio")
		String nome, 
		
		boolean status) {

	public CategoriaDTO(Categoria entity) {
		this(entity.getId(), entity.getNome(), entity.isStatus());
	}


}
