package com.br.pdvpostocombustivel.api.pessoa.dto;

import java.time.LocalDate;

public record PessoaResponse(
        Long id,                // <<< NOVO CAMPO
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        LocalDate dataNascimento
) {
}
