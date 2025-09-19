package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Acesso{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 200, nullable = false)
    private String usuario;

    @Column(length = 200, nullable = false)
    private String senha;


    //construtor
    public Acesso (String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    public Acesso(){

    }
    //getters


    public Long getId() {
        return id;
    }

    public String getUsuario() {


        return usuario;
    }

    public String getSenha() {


        return senha;
    }

    //setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(){


        this.usuario = usuario;
    }

    public void setSenha(){


        this.senha = senha;
    }
}
