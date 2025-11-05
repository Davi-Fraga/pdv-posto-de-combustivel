package com.br.pdvpostocombustivel.api.bico.dto;

import com.br.pdvpostocombustivel.enums.StatusBico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BicoRequest(
        @NotBlank(message = "O nome do bico não pode ser vazio.")
        String nome,
        @NotNull(message = "O status do bico é obrigatório.")
        StatusBico status,
        @NotNull(message = "O ID do produto é obrigatório.")
        Long produtoId
) {
}