package com.br.pdvpostocombustivel.api.pessoa.dto;

import java.math.BigDecimal;
import java.util.Date;

public record PrecoResponce(
        Long Id,
        BigDecimal valor,
        String dataAlteracao,
        Date horaAlteracao
) {
}
