package com.br.pdvpostocombustivel.enums;

public enum TipoCusto {
    FIXO("Custo Fixo"),
    VARIAVEL("Custo Variável"),
    IMPOSTO("Imposto"),
    MANUTENCAO("Manutenção"),
    SALARIOS("Salários");

    private final String descricao;

    TipoCusto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
