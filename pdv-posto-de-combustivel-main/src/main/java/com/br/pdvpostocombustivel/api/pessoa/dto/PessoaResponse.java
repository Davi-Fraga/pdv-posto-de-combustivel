package com.br.pdvpostocombustivel.api.pessoa.dto;
//Para Resposta


import java.time.LocalDate;
import com.br.pdvpostocombustivel.enums.TipoPessoa;

public record PessoaResponse(
        Long id,
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        LocalDate dataNascimento,
        TipoPessoa tipoPessoa
) {
}