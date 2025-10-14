package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.enums.TipoCusto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CustoRequest(
        @NotBlank(message = "A descrição não pode ser vazia.")
        String descricao,

        @NotNull(message = "O valor é obrigatório.")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
        BigDecimal valor,

        @NotNull(message = "A data de vencimento é obrigatória.")
        @FutureOrPresent(message = "A data de vencimento não pode ser no passado.")
        LocalDate dataVencimento,

        @NotNull(message = "O tipo de custo é obrigatório.")
        TipoCusto tipoCusto
) {
}
