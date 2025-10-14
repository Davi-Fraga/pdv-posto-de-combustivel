package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoPreco;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "precos")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O valor do preço é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor do preço deve ser maior que zero.")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull(message = "A data de vigência do preço é obrigatória.")
    @Column(name = "data_vigencia", nullable = false)
    private LocalDate dataVigencia;

    @NotNull(message = "O tipo de preço é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_preco", nullable = false, length = 20)
    private TipoPreco tipoPreco;

    @NotNull(message = "O preço deve estar associado a um item de estoque.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estoque_id", nullable = false)
    private Estoque estoque;

    /**
     * Construtor JPA
     */
    protected Preco() {
    }

    public Preco(BigDecimal valor, LocalDate dataVigencia, TipoPreco tipoPreco, Estoque estoque) {
        this.valor = valor;
        this.dataVigencia = dataVigencia;
        this.tipoPreco = tipoPreco;
        this.estoque = estoque;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataVigencia() {
        return dataVigencia;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    // Setters
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataVigencia(LocalDate dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Preco preco = (Preco) o;
        return Objects.equals(id, preco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Preco{" +
                "id=" + id +
                ", valor=" + valor +
                ", tipoPreco=" + tipoPreco +
                ", estoqueId=" + (estoque != null ? estoque.getId() : null) +
                '}';
    }
}
