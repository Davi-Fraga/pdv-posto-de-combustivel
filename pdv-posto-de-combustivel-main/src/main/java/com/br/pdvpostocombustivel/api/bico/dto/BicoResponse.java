package com.br.pdvpostocombustivel.api.bico.dto;

import com.br.pdvpostocombustivel.api.produto.dto.ProdutoResponse;
import com.br.pdvpostocombustivel.enums.StatusBico;

public record BicoResponse(
        Long id,
        String nome,
        StatusBico status,
        ProdutoResponse produto
) {
}