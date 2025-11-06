package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoCusto;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
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

    @NotNull(message = "O imposto é obrigatório.")
    @DecimalMin(value = "0.0", message = "O imposto deve ser maior ou igual a zero.")
    @Column(nullable = false)
    private BigDecimal imposto;

    @NotNull(message = "O custo variável é obrigatório.")
    @DecimalMin(value = "0.0", message = "O custo variável deve ser maior ou igual a zero.")
    @Column(name = "custo_variavel", nullable = false)
    private BigDecimal custoVariavel;

    @NotNull(message = "O custo fixo é obrigatório.")
    @DecimalMin(value = "0.0", message = "O custo fixo deve ser maior ou igual a zero.")
    @Column(name = "custo_fixo", nullable = false)
    private BigDecimal custoFixo;

    @NotNull(message = "A margem de lucro é obrigatória.")
    @DecimalMin(value = "0.0", message = "A margem de lucro deve ser maior ou igual a zero.")
    @Column(name = "margem_lucro", nullable = false)
    private BigDecimal margemLucro;

    @NotNull(message = "A data de processamento é obrigatória.")
    @Column(name = "data_processamento", nullable = false)
    private LocalDate dataProcessamento;

    @NotNull(message = "O tipo de custo é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_custo", nullable = false, length = 20)
    private TipoCusto tipoCusto;

    /**
     * Construtor JPA
     */
    protected Custo() {
    }

    public Custo(BigDecimal imposto, BigDecimal custoVariavel, BigDecimal custoFixo, BigDecimal margemLucro, LocalDate dataProcessamento, TipoCusto tipoCusto) {
        this.imposto = imposto;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.margemLucro = margemLucro;
        this.dataProcessamento = dataProcessamento;
        this.tipoCusto = tipoCusto;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public BigDecimal getImposto() {
        return imposto;
    }

    public BigDecimal getCustoVariavel() {
        return custoVariavel;
    }

    public BigDecimal getCustoFixo() {
        return custoFixo;
    }

    public BigDecimal getMargemLucro() {
        return margemLucro;
    }

    public LocalDate getDataProcessamento() {
        return dataProcessamento;
    }

    public TipoCusto getTipoCusto() {
        return tipoCusto;
    }

    // Setters
    public void setImposto(BigDecimal imposto) {
        this.imposto = imposto;
    }

    public void setCustoVariavel(BigDecimal custoVariavel) {
        this.custoVariavel = custoVariavel;
    }

    public void setCustoFixo(BigDecimal custoFixo) {
        this.custoFixo = custoFixo;
    }

    public void setMargemLucro(BigDecimal margemLucro) {
        this.margemLucro = margemLucro;
    }

    public void setDataProcessamento(LocalDate dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
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
                ", imposto=" + imposto +
                ", custoVariavel=" + custoVariavel +
                ", custoFixo=" + custoFixo +
                ", margemLucro=" + margemLucro +
                ", dataProcessamento=" + dataProcessamento +
                ", tipoCusto=" + tipoCusto +
                '}';
    }
}
