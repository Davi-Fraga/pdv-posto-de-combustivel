package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoContato;

public record ContatoResponse(
        Long id,
        TipoContato tipoContato,
        String valor,
        Long pessoaId // Incluir o ID da pessoa na resposta é útil para o cliente
) {
}
