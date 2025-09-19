package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Contato{

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String telefone;

    @Column(length = 200, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String endereco;




    // construtor
    public Contato(String telefone, String email, String endereco){
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;

    }

    public Contato(){

    }
    //getters


    public Long getId() {
        return id;
    }

    public String getTelefone(){
        return telefone;
    }

    public String getEmail(){
        return email;
    }

    public String getEndereco(){
        return endereco;
    }

    //setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
