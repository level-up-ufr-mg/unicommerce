package br.com.alura.util.domain.categoria;

public record DadosCategoria(Long id, Boolean status, String nome) {

    public DadosCategoria(Categoria categoria) {
    	this(categoria.getCategoriaId(), categoria.getStatus(), categoria.getNome());
    }
    
}