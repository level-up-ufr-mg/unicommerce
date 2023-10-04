package br.com.alura.unicommerce.record;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.NotBlank;

import br.com.alura.unicommerce.modelo.Categoria;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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
		Categoria categoria) {		
		
}
