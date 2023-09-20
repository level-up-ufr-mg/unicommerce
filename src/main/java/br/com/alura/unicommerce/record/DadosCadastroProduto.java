package br.com.alura.unicommerce.record;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.alura.unicommerce.modelo.Categoria;

public record DadosCadastroProduto(
		@NotBlank
		@Size(min = 2)
		String nome,
		
		@NotNull
		@Positive
		BigDecimal preco,
		
		String descricao,
		
		@NotNull
		Integer quantidadeEstoque,
		
		@NotNull(message = "O id da Categoria deve ser válido")
		Categoria categoria		
		) {

}
