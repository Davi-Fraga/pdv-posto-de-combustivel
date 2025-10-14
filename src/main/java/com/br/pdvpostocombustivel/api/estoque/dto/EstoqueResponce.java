package com.br.pdvpostocombustivel.api.estoque.dto;

import java.math.BigDecimal;

public record EstoqueResponce(
        Long Id,
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        String dataValidade
) {
}
