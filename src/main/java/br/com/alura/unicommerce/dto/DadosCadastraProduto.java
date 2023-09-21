package br.com.alura.unicommerce.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DadosCadastraProduto(
		
		@NotBlank
		String nome, 
		
		@NotNull
		@Positive(message = "Número deve ser um inteiro positivo")
		BigDecimal preco,
		
		String descricao,
		
		@NotNull
		Integer quantidadeEstoque,
		
		@NotNull
		Categoria categoria) {

}
