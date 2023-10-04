package br.com.alura.unicommerce.record;

import org.hibernate.validator.constraints.Length;

import br.com.alura.unicommerce.modelo.Categoria;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DadosNovaCategoria(@NotEmpty @NotNull @Length(min = 2) String nome) {
	
	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

}
