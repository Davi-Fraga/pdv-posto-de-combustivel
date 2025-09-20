package com.br.pdvpostocombustivel.enums;

public enum TipoPessoa {

    FISICA("Pessoa Física"),
    JURIDICA("Pesspa Jurídica");

    private final String descricao;

    private TipoPessoa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
