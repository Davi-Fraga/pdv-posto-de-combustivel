package com.br.pdvpostocombustivel.enums;

public enum TipoContato {
    EMAIL("E-mail"),
    TELEFONE("Telefone Fixo"),
    CELULAR("Telefone Celular");

    private final String descricao;

    TipoContato(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
