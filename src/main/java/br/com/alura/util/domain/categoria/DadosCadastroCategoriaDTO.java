package br.com.alura.util.domain.categoria;
public record DadosCadastroCategoriaDTO( 

		String nome) {

	public Categoria toEntity() {
		return new Categoria(this.nome);
	}

}
