package com.br.domain.entity;

public class Produto {

    private String nome;
    private  String referencia;
    private String fornecedor;
    private String categoria;
    private String marca;


    public Produto (String nome, String referencia, String fornecedor, String categoria, String marca) {
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.marca = marca;
    }


    public String getNome() {
        return nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
};