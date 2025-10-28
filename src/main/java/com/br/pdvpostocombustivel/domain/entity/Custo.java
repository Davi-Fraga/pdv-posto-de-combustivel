package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoCusto;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "custo")
public class Custo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição não pode ser vazia.")
    @Column(nullable = false, length = 255)
    private String descricao;

    @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull(message = "A data de vencimento é obrigatória.")
    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @NotNull(message = "O tipo de custo é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_custo", nullable = false, length = 20)
    private TipoCusto tipoCusto;

    /**
     * Construtor JPA
     */
    protected Custo() {
    }

    public Custo(String descricao, BigDecimal valor, LocalDate dataVencimento, TipoCusto tipoCusto) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.tipoCusto = tipoCusto;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public TipoCusto getTipoCusto() {
        return tipoCusto;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setTipoCusto(TipoCusto tipoCusto) {
        this.tipoCusto = tipoCusto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Custo custo = (Custo) o;
        return Objects.equals(id, custo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Custo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", tipoCusto=" + tipoCusto +
                '}';
    }
}
