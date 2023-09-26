package br.com.alura.util.Domain.Produto;

import java.math.BigDecimal;

import br.com.alura.util.Domain.Categoria.Categoria;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroProdutoDTO(
		@NotBlank
		String nome ,
		
		String descricao,
		
		@NotNull
		@Positive
		Long quantidadeEstoque ,
		
		@NotNull
		@Positive
		BigDecimal preco,
		
		@Valid
		@NotNull
		Categoria categoria) {

}
