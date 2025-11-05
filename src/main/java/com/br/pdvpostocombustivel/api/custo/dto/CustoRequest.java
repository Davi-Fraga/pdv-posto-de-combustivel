package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.enums.TipoCusto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CustoRequest(
        @NotNull(message = "O imposto é obrigatório.")
        @DecimalMin(value = "0.0", message = "O imposto deve ser maior ou igual a zero.")
        BigDecimal imposto,

        @NotNull(message = "O custo variável é obrigatório.")
        @DecimalMin(value = "0.0", message = "O custo variável deve ser maior ou igual a zero.")
        BigDecimal custoVariavel,

        @NotNull(message = "O custo fixo é obrigatório.")
        @DecimalMin(value = "0.0", message = "O custo fixo deve ser maior ou igual a zero.")
        BigDecimal custoFixo,

        @NotNull(message = "A margem de lucro é obrigatória.")
        @DecimalMin(value = "0.0", message = "A margem de lucro deve ser maior ou igual a zero.")
        BigDecimal margemLucro,

        @NotNull(message = "A data de processamento é obrigatória.")
        LocalDate dataProcessamento,

        @NotNull(message = "O tipo de custo é obrigatório.")
        TipoCusto tipoCusto
) {
}
