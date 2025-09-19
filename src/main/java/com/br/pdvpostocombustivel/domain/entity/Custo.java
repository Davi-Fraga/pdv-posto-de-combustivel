package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

public class Custo{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private Double imposto;

    @Column(nullable = false)
    private Double custoVariavel;

    @Column(nullable = false)
    private Double custoFixo;

    @Column(nullable = false)
    private Double margemLucro;

    @Column(nullable = false)
    private Date dataProcessamento;




    public Custo (Double custoFixo, Double imposto, Double custoVariavel, Double margemLucro, Date dataProcessamento){
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.dataProcessamento = dataProcessamento;
        this.margemLucro = margemLucro;

    }


    public Custo(){

    }
    //getters


    public Long getId() {
        return id;
    }

    public Double getImposto() {
        return imposto;
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setImposto(Double imposto) {
        this.imposto = imposto;
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
