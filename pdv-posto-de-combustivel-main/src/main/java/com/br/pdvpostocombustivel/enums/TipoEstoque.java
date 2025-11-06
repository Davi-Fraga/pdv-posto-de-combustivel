package com.br.pdvpostocombustivel.enums;

public enum TipoEstoque {
    GASOLINA_COMUM("Gasolina Comum"),
    GASOLINA_ADITIVADA("Gasolina Aditivada"),
    ETANOL("Etanol"),
    DIESEL_S10("Diesel S10"),
    DIESEL_S500("Diesel S500");

    private final String descricao;

    TipoEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
