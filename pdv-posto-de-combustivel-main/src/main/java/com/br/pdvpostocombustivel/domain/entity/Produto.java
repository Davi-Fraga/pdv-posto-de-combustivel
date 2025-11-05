package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produto", uniqueConstraints = {
        @UniqueConstraint(name = "uk_produto_referencia", columnNames = "referencia")
})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto não pode ser vazio.")
    @Column(nullable = false, length = 150)
    private String nome;

    @NotBlank(message = "A referência não pode ser vazia.")
    @Column(nullable = false, unique = true, length = 50)
    private String referencia;

    @NotBlank(message = "O fornecedor não pode ser vazio.")
    @Column(nullable = false, length = 150)
    private String fornecedor;

    @NotBlank(message = "A marca não pode ser vazia.")
    @Column(nullable = false, length = 100)
    private String marca;

    @NotBlank(message = "A categoria não pode ser vazia.")
    @Column(nullable = false, length = 100)
    private String categoria;

    @NotNull(message = "O tipo de produto é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_produto", nullable = false, length = 20)
    private TipoProduto tipoProduto;

    @DecimalMin(value = "0.0", message = "O preço de venda não pode ser negativo.")
    @Column(name = "preco_venda")
    private BigDecimal precoVenda;

    /**
     * Construtor JPA
     */
    protected Produto() {
    }

    public Produto(String nome, String referencia, String fornecedor, String marca, String categoria, TipoProduto tipoProduto, BigDecimal precoVenda) {
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.categoria = categoria;
        this.tipoProduto = tipoProduto;
        this.precoVenda = precoVenda;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(referencia, produto.referencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, referencia);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", referencia='" + referencia + '\'' +
                ", tipoProduto=" + tipoProduto +
                '}';
    }
}
