package com.br.pdvpostocombustivel.api.contato.dto;

public record ContatoRequest(
        Long id,
        String telefone,
        String email,
        String endereco
) {
}
