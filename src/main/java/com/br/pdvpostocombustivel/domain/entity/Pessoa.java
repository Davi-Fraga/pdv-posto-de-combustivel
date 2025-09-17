package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import jakarta.websocket.OnMessage;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "pessoa")

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //atributos
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCompleto;


    @Column(length = 14, nullable = false)
    private String cpfCnpj;

    @Column(length = 10, nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 20)
    private Long numeroCtps;



    //construtor
    public Pessoa (String nomeCompleto, String cpfCnpj, LocalDate dataNascimento, Long numeroCtps){
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    };

    public Pessoa() {

    }


    //getters


    public Long getId() {
        return id;
    }

    public String getNomeCompleto(){
        return nomeCompleto;
    };

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Long getNumeroCtps() {
        return numeroCtps;
    }

    //setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    };

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNumeroCtps(Long numeroCtps) {
        this.numeroCtps = numeroCtps;
    }
};
