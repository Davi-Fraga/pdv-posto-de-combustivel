package com.br.pdvpostocombustivel.api.acesso.dto;

import com.br.pdvpostocombustivel.enums.TipoAcesso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AcessoRequest(
        @NotBlank(message = "O nome de usuário não pode ser vazio.")
        @Size(min = 4, max = 200, message = "O nome de usuário deve ter entre 4 e 200 caracteres.")
        String usuario,

        @NotBlank(message = "A senha não pode ser vazia.")
        @Size(min = 6, max = 200, message = "A senha deve ter entre 6 e 200 caracteres.")
        String senha,

        @NotNull(message = "O tipo de acesso é obrigatório.")
        TipoAcesso tipoAcesso
) {
}
