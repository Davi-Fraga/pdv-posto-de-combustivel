package com.br.pdvpostocombustivel.api.produto.dto;

import com.br.pdvpostocombustivel.enums.TipoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

public record ProdutoRequest(
        @NotBlank(message = "O nome do produto não pode ser vazio.")
        @Size(max = 150, message = "O nome do produto não pode exceder 150 caracteres.")
        String nome,

        @NotBlank(message = "A referência não pode ser vazia.")
        @Size(max = 50, message = "A referência não pode exceder 50 caracteres.")
        String referencia,

        @NotBlank(message = "O fornecedor não pode ser vazio.")
        @Size(max = 150, message = "O fornecedor não pode exceder 150 caracteres.")
        String fornecedor,

        @NotBlank(message = "A marca não pode ser vazia.")
        @Size(max = 100, message = "A marca não pode exceder 100 caracteres.")
        String marca,

        @NotBlank(message = "A categoria não pode ser vazia.")
        @Size(max = 100, message = "A categoria não pode exceder 100 caracteres.")
        String categoria,

        @NotNull(message = "O tipo de produto é obrigatório.")
        TipoProduto tipoProduto,

        @DecimalMin(value = "0.0", message = "O preço de venda não pode ser negativo.")
        BigDecimal precoVenda
) {
}
