package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Categoria;

public record DadosDetalhamentoCategoria(
		
		String nome,
		
		Boolean status) {

	public DadosDetalhamentoCategoria(Categoria categoria) {
		this(categoria.getNome(), categoria.getStatus());
	}
	
}
