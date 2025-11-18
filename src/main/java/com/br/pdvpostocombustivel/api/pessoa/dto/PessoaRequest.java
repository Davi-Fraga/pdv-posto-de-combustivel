package com.br.pdvpostocombustivel.api.pessoa.dto;

import com.br.pdvpostocombustivel.enums.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//Para Entrada
public record PessoaRequest(
        @NotBlank(message = "O nome completo é obrigatório")
        @Size(max = 200, message = "O nome completo deve ter no máximo 200 caracteres")
        String nomeCompleto,

        @NotBlank(message = "O CPF/CNPJ é obrigatório")
        @Size(max = 20, message = "O CPF/CNPJ deve ter no máximo 20 caracteres")
        String cpfCnpj,

        Long numeroCtps,

        @NotNull(message = "A data de nascimento é obrigatória")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dataNascimento,

        @NotNull(message = "O tipo de pessoa é obrigatório")
        TipoPessoa tipoPessoa
)
{}
