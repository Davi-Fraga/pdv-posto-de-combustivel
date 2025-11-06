package com.br.pdvpostocombustivel.enums;

public enum StatusBico {
    LIVRE("Livre"),
    EM_USO("Em Uso"),
    AGUARDANDO_PAGAMENTO("Aguardando Pagamento"),
    BLOQUEADO("Bloqueado");

    private final String descricao;

    StatusBico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() { return descricao; }
}