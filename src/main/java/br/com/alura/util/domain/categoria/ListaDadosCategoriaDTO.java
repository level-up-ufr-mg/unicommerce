package br.com.alura.util.domain.categoria;
public record ListaDadosCategoriaDTO(Long id,String nome,Boolean status) {
	
	public ListaDadosCategoriaDTO (Categoria categoria) {
		this(categoria.getCategoriaId(),categoria.getNome(), categoria.getStatus());
	}
	

}
