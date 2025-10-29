package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.enums.TipoPreco;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record PrecoResponse(
        Long id,
        LocalDate dataAlteracao,
        LocalTime horaAlteracao,
        BigDecimal valor,
        TipoPreco tipoPreco
) {
}
