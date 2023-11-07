package br.com.alura.unicommerce.DTO;

import br.com.alura.unicommerce.Domain.Categoria.Categoria;

public record DadosDetalhamentoCategoria(String nome, Boolean status) {
	public DadosDetalhamentoCategoria(Categoria categoria) {
		this(categoria.getNome(), categoria.getStatus());
	}
}