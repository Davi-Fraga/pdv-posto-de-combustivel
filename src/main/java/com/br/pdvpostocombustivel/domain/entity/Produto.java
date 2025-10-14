package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produtos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_produto_codigo_barras", columnNames = "codigo_barras")
})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @NotBlank(message = "O código de barras não pode ser vazio.")
    @Column(name = "codigo_barras", nullable = false, unique = true, length = 50)
    private String codigoBarras;

    @NotNull(message = "O valor unitário é obrigatório.")
    @DecimalMin(value = "0.0", message = "O valor unitário não pode ser negativo.")
    @Column(name = "valor_unitario", nullable = false)
    private BigDecimal valorUnitario;

    @NotNull(message = "O tipo de produto é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_produto", nullable = false, length = 20)
    private TipoProduto tipoProduto;

    /**
     * Construtor JPA
     */
    protected Produto() {
    }

    public Produto(String nome, String descricao, String codigoBarras, BigDecimal valorUnitario, TipoProduto tipoProduto) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.valorUnitario = valorUnitario;
        this.tipoProduto = tipoProduto;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(codigoBarras, produto.codigoBarras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarras);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", tipoProduto=" + tipoProduto +
                '}';
    }
}
