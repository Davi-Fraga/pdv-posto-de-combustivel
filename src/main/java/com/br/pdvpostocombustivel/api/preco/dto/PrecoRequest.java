package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.enums.TipoPreco;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrecoRequest(
        @NotNull(message = "O valor do preço é obrigatório.")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor do preço deve ser maior que zero.")
        BigDecimal valor,

        @NotNull(message = "A data de vigência é obrigatória.")
        LocalDate dataVigencia,

        @NotNull(message = "O tipo de preço é obrigatório.")
        TipoPreco tipoPreco
) {
}
