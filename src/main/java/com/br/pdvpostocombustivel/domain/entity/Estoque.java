package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O tipo do produto em estoque é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estoque", nullable = false, length = 25)
    private TipoEstoque tipoEstoque;

    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nomeProduto;

    @NotNull(message = "A quantidade é obrigatória.")
    @DecimalMin(value = "0.0", message = "A quantidade não pode ser negativa.")
    @Column(nullable = false)
    private BigDecimal quantidade;

    @NotBlank(message = "O nome do fornecedor não pode ser vazio.")
    @Column(nullable = false, length = 150)
    private String fornecedor;

    @NotNull(message = "A data de entrada é obrigatória.")
    @Column(name = "data_entrada", nullable = false)
    private LocalDate dataEntrada;

    /**
     * Construtor JPA
     */
    protected Estoque() {
    }

    public Estoque(TipoEstoque tipoEstoque, String nomeProduto, BigDecimal quantidade, String fornecedor, LocalDate dataEntrada) {
        this.tipoEstoque = tipoEstoque;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.dataEntrada = dataEntrada;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public TipoEstoque getTipoEstoque() {
        return tipoEstoque;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    // Setters
    public void setTipoEstoque(TipoEstoque tipoEstoque) {
        this.tipoEstoque = tipoEstoque;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", tipoEstoque=" + tipoEstoque +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
