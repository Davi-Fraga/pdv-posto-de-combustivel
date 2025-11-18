package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoContato;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ContatoRequest(

        @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres.")
        String telefone,

        @Email(message = "O formato do e-mail é inválido.")
        @Size(max = 100, message = "O e-mail deve ter no máximo 100 caracteres.")
        String email,

        @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres.")
        String endereco,

        @NotNull(message = "O tipo de contato é obrigatório.")
        TipoContato tipoContato,

        @NotNull(message = "O ID da Pessoa é obrigatório.")
        Long pessoaId
) {
}
