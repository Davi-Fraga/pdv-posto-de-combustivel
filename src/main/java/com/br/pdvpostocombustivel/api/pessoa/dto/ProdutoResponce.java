package com.br.pdvpostocombustivel.api.pessoa.dto;

public record ProdutoResponce(
        Long id,
        String nome,
        String fornecedor,
        String referencia,
        String categoria,
        String marca
) {
}
