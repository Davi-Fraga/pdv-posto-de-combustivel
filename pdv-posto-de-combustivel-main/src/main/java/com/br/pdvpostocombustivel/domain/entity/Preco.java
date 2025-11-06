package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoPreco;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "preco")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data de alteração do preço é obrigatória.")
    @Column(name = "data_alteracao", nullable = false)
    private LocalDate dataAlteracao;

    @NotNull(message = "A hora de alteração do preço é obrigatória.")
    @Column(name = "hora_alteracao", nullable = false)
    private LocalTime horaAlteracao;

    @NotNull(message = "O valor do preço é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor do preço deve ser maior que zero.")
    @Column(nullable = false)
    private BigDecimal valor;

    @NotNull(message = "O tipo de preço é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_preco", nullable = false, length = 20)
    private TipoPreco tipoPreco;

    /**
     * Construtor JPA
     */
    protected Preco() {
    }

    public Preco(LocalDate dataAlteracao, LocalTime horaAlteracao, BigDecimal valor, TipoPreco tipoPreco) {
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
        this.valor = valor;
        this.tipoPreco = tipoPreco;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public LocalTime getHoraAlteracao() {
        return horaAlteracao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TipoPreco getTipoPreco() {
        return tipoPreco;
    }


    // Setters
    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void setHoraAlteracao(LocalTime horaAlteracao) {
        this.horaAlteracao = horaAlteracao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setTipoPreco(TipoPreco tipoPreco) {
        this.tipoPreco = tipoPreco;
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
                ", dataAlteracao=" + dataAlteracao +
                ", horaAlteracao=" + horaAlteracao +
                '}';
    }
}
