package com.br.pdvpostocombustivel.api.pessoa.dto;
//Para Resposta


import java.time.LocalDate;

public record PessoaResponce(
        Long id,
        String nomeCompleto,
        String cpfCnpj,
        Long numeroCtps,
        LocalDate dataNascimento
) {
}