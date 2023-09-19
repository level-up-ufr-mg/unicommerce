package br.com.alura.util.Cliente;

import br.com.alura.util.Endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroClienteDTO( 
	    @NotBlank
	    String nome,
	    @NotNull
	    @Digits(integer = 11, fraction = 0, message = "O CPF deve conter 11 dígitos")
	    Long cpf,
	    @NotNull
	    @Digits(integer = 11, fraction = 0, message = "O CPF deve conter 11 dígitos")//37998111111
	    Long telefone,
	    @NotNull
	    @Valid
	    Endereco endereco
	) {
	}
