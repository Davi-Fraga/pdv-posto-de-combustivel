package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


import java.math.BigDecimal;
@Entity
@Table(name = "estoque ")

public class Estoque {


    @Column(nullable = false)
    private BigDecimal quantidade;

    @Column(length = 200, nullable = false)
    private String LocalTanque;

    @Column(length = 200, nullable = false)
    private String LocalEndereco;

    @Column(length = 200, nullable = false)
    private String LoteFabricacao;

    @Column(length = 10, nullable = false)
    private String dataValidade;


    public Estoque(BigDecimal quantidade, String LocalTanque, String LocalEndereco, String LoteFabricacao, String dataValidade){
        this.quantidade = quantidade;
        this.LocalTanque= LocalTanque;
        this.LocalEndereco = LocalEndereco;
        this.LoteFabricacao = LoteFabricacao;
        this.dataValidade = dataValidade;

    }

    public Estoque(){

    }
    //Getters




    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public String getLocalTanque(){
        return LocalTanque;
    }

    public String getLocalEndereco() {
        return LocalEndereco;
    }

    public String getLoteFabricacao() {
        return LoteFabricacao;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    //Setters



    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setLocalTanque(String localTanque) {
        LocalTanque = localTanque;
    }

    public void setLocalEndereco(String localEndereco) {
        LocalEndereco = localEndereco;
    }

    public void setLoteFabricacao(String loteFabricacao) {
        LoteFabricacao = loteFabricacao;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }
}