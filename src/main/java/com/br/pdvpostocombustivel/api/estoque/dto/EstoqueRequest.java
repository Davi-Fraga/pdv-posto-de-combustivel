package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EstoqueRequest(
        @NotNull(message = "A quantidade é obrigatória.")
        @DecimalMin(value = "0.0", message = "A quantidade não pode ser negativa.")
        BigDecimal quantidade,

        @NotBlank(message = "O local do tanque não pode ser vazio.")
        String localTanque,

        @NotBlank(message = "O endereço do local não pode ser vazio.")
        String localEndereco,

        @NotBlank(message = "O lote de fabricação não pode ser vazio.")
        String loteFabricacao,

        @NotNull(message = "A data de validade é obrigatória.")
        LocalDate dataValidade,

        @NotNull(message = "O tipo do produto em estoque é obrigatório.")
        TipoEstoque tipoEstoque
) {
}
