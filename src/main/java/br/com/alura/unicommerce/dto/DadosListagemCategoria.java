package br.com.alura.unicommerce.dto;

import br.com.alura.unicommerce.modelo.Categoria;

public record DadosListagemCategoria(String nome, boolean status) {

	public DadosListagemCategoria(Categoria categoria) {
        this(categoria.getNome(), categoria.isStatus());
    }
}
