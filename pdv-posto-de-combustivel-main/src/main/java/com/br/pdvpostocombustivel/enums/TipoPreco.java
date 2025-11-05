package com.br.pdvpostocombustivel.enums;

public enum TipoPreco {
    PRECO_DE_CUSTO("Preço de Custo"),
    PRECO_DE_VENDA("Preço de Venda");

    private final String descricao;

    TipoPreco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
