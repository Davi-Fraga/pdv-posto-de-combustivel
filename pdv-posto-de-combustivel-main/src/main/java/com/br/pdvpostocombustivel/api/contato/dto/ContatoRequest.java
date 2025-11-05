package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoContato;
import jakarta.validation.constraints.NotNull;

public record ContatoRequest(
        String telefone,
        String email,
        String endereco,
        @NotNull(message = "O tipo de contato é obrigatório.")
        TipoContato tipoContato
) {
}
