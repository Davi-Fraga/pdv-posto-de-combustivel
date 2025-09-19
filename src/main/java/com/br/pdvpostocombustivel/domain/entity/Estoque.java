package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.aot.generate.GeneratedMethod;

import java.math.BigDecimal;
import java.util.Date;

public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    public Long getId() {
        return id;
    }

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


    public void setId(Long id) {
        this.id = id;
    }

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