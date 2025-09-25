package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "acesso")

public class Acesso{




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



    public String getUsuario() {


        return usuario;
    }

    public String getSenha() {


        return senha;
    }

    //setters




    public void setUsuario(){


        this.usuario = usuario;
    }

    public void setSenha(){


        this.senha = senha;
    }
}
