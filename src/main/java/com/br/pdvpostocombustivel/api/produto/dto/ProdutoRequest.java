package com.br.pdvpostocombustivel.api.produto.dto;

import com.br.pdvpostocombustivel.enums.TipoProduto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProdutoRequest(
        @NotBlank(message = "O nome do produto não pode ser vazio.")
        @Size(max = 150, message = "O nome do produto não pode exceder 150 caracteres.")
        String nome,

        @Size(max = 255, message = "A descrição não pode exceder 255 caracteres.")
        String descricao,

        @NotBlank(message = "O código de barras não pode ser vazio.")
        @Size(max = 50, message = "O código de barras não pode exceder 50 caracteres.")
        String codigoBarras,

        @NotNull(message = "O valor unitário é obrigatório.")
        @DecimalMin(value = "0.0", message = "O valor unitário não pode ser negativo.")
        BigDecimal valorUnitario,

        @NotNull(message = "O tipo de produto é obrigatório.")
        TipoProduto tipoProduto
) {
}
