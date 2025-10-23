package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoContato;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Objects;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String telefone;

    @Email(message = "E-mail inválido.")
    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 255)
    private String endereco;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contato", nullable = false)
    private TipoContato tipoContato;

    /**
     * Construtor JPA
     */
    protected Contato() {
    }

    public Contato(String telefone, String email, String endereco, TipoContato tipoContato) {
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.tipoContato = tipoContato;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", tipoContato=" + tipoContato +
                '}';
    }
}
