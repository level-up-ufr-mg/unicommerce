package br.com.alura.util.domain.cliente;

import br.com.alura.util.domain.endereco.Endereco;
import br.com.alura.util.domain.usuario.Usuario;
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
	    Endereco endereco,
	    
	    @NotNull
	    @Valid
	    Usuario usuario
	    
	    
	) {
	}
