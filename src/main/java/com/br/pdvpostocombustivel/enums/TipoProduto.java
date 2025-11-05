package com.br.pdvpostocombustivel.enums;

public enum TipoProduto {
    COMBUSTIVEL("Combustível"),
    LUBRIFICANTE("Lubrificante"),
    ADITIVO("Aditivo"),
    CONVENIENCIA("Loja de Conveniência");

    private final String descricao;

    TipoProduto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
