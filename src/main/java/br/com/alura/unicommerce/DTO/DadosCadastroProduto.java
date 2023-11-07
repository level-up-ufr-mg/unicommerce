package br.com.alura.unicommerce.DTO;

import java.math.BigDecimal;

import br.com.alura.unicommerce.Domain.Categoria.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastroProduto(@NotBlank String nome,
		@NotNull @Positive(message = "Número deve ser um inteiro positivo") BigDecimal preco, String descricao,
		@NotNull Integer quantidadeEstoque, @NotNull Categoria categoria) {
}
