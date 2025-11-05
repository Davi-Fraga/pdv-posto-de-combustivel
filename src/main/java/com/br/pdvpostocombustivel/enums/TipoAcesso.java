package com.br.pdvpostocombustivel.enums;

public enum TipoAcesso {
    ADMIN("Administrador"),
    USER("Usuário");

    private final String descricao;

    TipoAcesso(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
