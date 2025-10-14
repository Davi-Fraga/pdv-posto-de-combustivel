package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoContato;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O tipo de contato é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_contato", nullable = false, length = 15)
    private TipoContato tipoContato;

    @NotBlank(message = "O valor do contato não pode ser vazio.")
    @Column(nullable = false, length = 255)
    private String valor;

    @NotNull(message = "O contato deve estar associado a uma pessoa.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    /**
     * Construtor JPA
     */
    protected Contato() {
    }

    public Contato(TipoContato tipoContato, String valor, Pessoa pessoa) {
        this.tipoContato = tipoContato;
        this.valor = valor;
        this.pessoa = pessoa;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public String getValor() {
        return valor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    // Setters
    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
                ", tipoContato=" + tipoContato +
                ", valor='" + valor + '\'' +
                '}';
    }
}
