package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Categoria;

public record DadosListagemCategoria(Long id, String nome, boolean status) {

	public DadosListagemCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getNome(), categoria.isStatus());
    }
}
