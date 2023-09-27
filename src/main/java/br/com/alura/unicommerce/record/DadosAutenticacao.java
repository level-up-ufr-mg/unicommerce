package br.com.alura.unicommerce.record;

import javax.validation.constraints.NotNull;

public record DadosAutenticacao(@NotNull String email, @NotNull String senha) {

}
