package com.br.pdvpostocombustivel.api.pessoa.dto;

public record ContatoRequest(
        Long id,
        String telefone,
        String email,
        String endereco
) {
}
