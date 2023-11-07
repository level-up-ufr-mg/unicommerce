package br.com.alura.unicommerce.DTO;

import org.hibernate.validator.constraints.Length;

import br.com.alura.unicommerce.Domain.Categoria.Categoria;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosNovaCategoria(@NotEmpty @NotNull @Length(min = 2) String nome) {
	
	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

}