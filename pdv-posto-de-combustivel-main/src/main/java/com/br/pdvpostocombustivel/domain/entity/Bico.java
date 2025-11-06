package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.StatusBico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "bico", uniqueConstraints = {
        @UniqueConstraint(name = "uk_bico_nome", columnNames = "nome")
})
public class Bico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do bico não pode ser vazio.")
    @Column(nullable = false, unique = true, length = 50)
    private String nome;

    @NotNull(message = "O status do bico é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private StatusBico status;

    @NotNull(message = "O bico deve estar associado a um produto.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    /**
     * Construtor JPA
     */
    protected Bico() {
    }

    public Bico(String nome, StatusBico status, Produto produto) {
        this.nome = nome;
        this.status = status;
        this.produto = produto;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatusBico getStatus() {
        return status;
    }

    public Produto getProduto() {
        return produto;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(StatusBico status) {
        this.status = status;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bico bico = (Bico) o;
        return Objects.equals(id, bico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Bico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                ", produtoId=" + (produto != null ? produto.getId() : "null") +
                '}';
    }
}