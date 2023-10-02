package br.com.alura.unicommerce.record;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(@NotNull String email, @NotNull String senha) {

}
