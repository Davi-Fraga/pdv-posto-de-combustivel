package com.br.domain.entity;

import java.util.Date;

public class Custo{

    private Double imposto;
    private Double frete;
    private Double custoVariavel;
    private Double custoFixo;
    private Double margemLucro;
    private Date dataProcessamento;


    public Custo (Double imposto, Double frete, Double custoFixo, Double custoVariavel, Double margemLucro, Date dataProcessamento){
        this.imposto = imposto;
        this.frete = frete;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.dataProcessamento = dataProcessamento;
        this.margemLucro = margemLucro;

    }

    //getters
    public Double getImposto() {
        return imposto;
    }

    public Double getFrete() {
        return frete;
    }

    public Double getCustoVariavel() {
        return custoVariavel;
    }

    public Double getCustoFixo() {
        return custoFixo;
    }

    public Double getMargemLucro() {
        return margemLucro;
    }

    public Date getDataProcessamento() {
        return dataProcessamento;
    }


    //setters
    public void setImposto(Double imposto) {
        this.imposto = imposto;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public void setCustoVariavel(Double custoVariavel) {
        this.custoVariavel = custoVariavel;
    }

    public void setCustoFixo(Double custoFixo) {
        this.custoFixo = custoFixo;
    }

    public void setMargemLucro(Double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public void setDataProcessamento(Date dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }
}