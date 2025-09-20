package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoPessoa;
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

    @Column(name = "nome_completo", length = 200, nullable = false)
    private String nomeCompleto;


    @Column(name ="cpf_cnpj",length = 14, nullable = false)
    private String cpfCnpj;

    @Column(name = "data_nascimento", length = 10, nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "numero_ctps",length = 20)
    private Long numeroCtps;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo pessoa", nullable = false, length = 15)
    private TipoPessoa tipoPessoa;


    //construtor
    public Pessoa (String nomeCompleto, String cpfCnpj, LocalDate dataNascimento, Long numeroCtps, TipoPessoa tipoPessoa){
        this.tipoPessoa = tipoPessoa;
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    };

    public Pessoa() {

    }


    //getters


    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

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


    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

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
