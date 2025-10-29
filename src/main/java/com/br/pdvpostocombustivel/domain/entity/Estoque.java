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

    @NotNull(message = "A quantidade é obrigatória.")
    @DecimalMin(value = "0.0", message = "A quantidade não pode ser negativa.")
    @Column(nullable = false)
    private BigDecimal quantidade;

    @NotBlank(message = "O local do tanque não pode ser vazio.")
    @Column(name = "local_tanque", nullable = false, length = 100)
    private String localTanque;

    @NotBlank(message = "O endereço do local não pode ser vazio.")
    @Column(name = "local_endereco", nullable = false, length = 255)
    private String localEndereco;

    @NotBlank(message = "O lote de fabricação não pode ser vazio.")
    @Column(name = "lote_fabricacao", nullable = false, length = 50)
    private String loteFabricacao;

    @NotNull(message = "A data de validade é obrigatória.")
    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;

    @NotNull(message = "O tipo do produto em estoque é obrigatório.")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estoque", nullable = false, length = 25)
    private TipoEstoque tipoEstoque;

    /**
     * Construtor JPA
     */
    protected Estoque() {
    }

    public Estoque(BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao, LocalDate dataValidade, TipoEstoque tipoEstoque) {
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
        this.dataValidade = dataValidade;
        this.tipoEstoque = tipoEstoque;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public String getLocalTanque() {
        return localTanque;
    }

    public String getLocalEndereco() {
        return localEndereco;
    }

    public String getLoteFabricacao() {
        return loteFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public TipoEstoque getTipoEstoque() {
        return tipoEstoque;
    }

    // Setters
    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setLocalTanque(String localTanque) {
        this.localTanque = localTanque;
    }

    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }

    public void setLoteFabricacao(String loteFabricacao) {
        this.loteFabricacao = loteFabricacao;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setTipoEstoque(TipoEstoque tipoEstoque) {
        this.tipoEstoque = tipoEstoque;
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
                ", quantidade=" + quantidade +
                ", localTanque='" + localTanque + '\'' +
                ", dataValidade=" + dataValidade +
                ", tipoEstoque=" + tipoEstoque +
                '}';
    }
}
