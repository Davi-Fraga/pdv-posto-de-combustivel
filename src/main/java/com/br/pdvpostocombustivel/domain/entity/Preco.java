package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "preco")

public class Preco{


    // Atributos

    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;


    @Column(length = 10, nullable = false)
    private String dataAlteracao;

    @Column(nullable = false)
    private Date horaAlteracao;







    public Preco (BigDecimal valor, String dataAlteracao, Date horaAlteracao){

        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }


    public Preco(){

    }



    public BigDecimal getValor() {
        return valor;
    }

    public String getDataAlteracao(){
        return dataAlteracao;
    }

    public Date getHoraAlteracao(){
        return horaAlteracao;
    }



    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setHoraAlteracao(Date horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }
}
