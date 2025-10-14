package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoRequest(
        @NotNull(message = "O tipo de contato é obrigatório.")
        TipoContato tipoContato,

        @NotBlank(message = "O valor do contato não pode ser vazio.")
        String valor
) {
}
