package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoAcesso;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "acesso", uniqueConstraints = {
        @UniqueConstraint(name = "uk_acesso_usuario", columnNames = "usuario")
})
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false, unique = true)
    private String usuario;

    @Column(length = 200, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acesso", nullable = false, length = 15)
    private TipoAcesso tipoAcesso;

    /**
     * Construtor JPA
     */
    protected Acesso() {
    }

    public Acesso(String usuario, String senha, TipoAcesso tipoAcesso) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public TipoAcesso getTipoAcesso() {
        return tipoAcesso;
    }

    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipoAcesso(TipoAcesso tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acesso acesso = (Acesso) o;
        return Objects.equals(id, acesso.id) && Objects.equals(usuario, acesso.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario);
    }

    @Override
    public String toString() {
        return "Acesso{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", tipoAcesso=" + tipoAcesso +
                '}';
    }
}
