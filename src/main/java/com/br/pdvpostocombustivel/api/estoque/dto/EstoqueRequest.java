package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueRequest(
        @NotNull(message = "O tipo do produto em estoque é obrigatório.")
        TipoEstoque tipoEstoque,

        @NotBlank(message = "O nome do produto não pode ser vazio.")
        String nomeProduto,

        @NotNull(message = "A quantidade é obrigatória.")
        @DecimalMin(value = "0.0", message = "A quantidade não pode ser negativa.")
        BigDecimal quantidade,

        @NotBlank(message = "O nome do fornecedor não pode ser vazio.")
        String fornecedor,

        @NotNull(message = "A data de entrada é obrigatória.")
        @PastOrPresent(message = "A data de entrada não pode ser no futuro.")
        LocalDate dataEntrada
) {
}
