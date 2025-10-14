package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.enums.TipoPreco;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrecoResponse(
        Long id,
        BigDecimal valor,
        LocalDate dataVigencia,
        TipoPreco tipoPreco,
        Long estoqueId
) {
}
