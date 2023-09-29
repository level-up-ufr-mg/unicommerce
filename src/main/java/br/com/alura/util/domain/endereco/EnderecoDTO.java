package br.com.alura.util.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
        @NotBlank
        String rua,
        
        @NotNull
        Long numero,
        
        String complemento,
        
        @NotBlank
        String bairro,
        
        @NotBlank
        String cidade,
        
        @NotBlank
        String estado) {

}

